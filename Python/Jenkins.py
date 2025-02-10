import re

class JenkinsfileGenerator:
    def __init__(self):
        self.templates = {
            'build': {
                'pattern': r'(build|compile|package)',
                'stage': '''stage('Build') {{
                    steps {{
                        sh '{build_command}'
                    }}
                }}'''
            },
            'test': {
                'pattern': r'(test|verify|check)',
                'stage': '''stage('Test') {{
                    steps {{
                        sh '{test_command}'
                    }}
                }}'''
            },
            'deploy': {
                'pattern': r'\b(deploy|release|ship)\b.*?\b(to\s+)?(staging|production|prod)\b',
                'stage': '''stage('Deploy to {environment}') {{
                    steps {{
                        script {{
                            if (env.BRANCH_NAME == 'main') {{
                                sh '{deploy_command}'
                            }}
                        }}
                    }}
                }}'''
            }
        }

    def parse_requirements(self, text):
        
        requirements = {
            'build_command': 'mvn clean package',
            'test_command': 'mvn test',
            'deploy_command': 'kubectl apply -f deployment.yaml',
            'environment': 'staging'
        }

        if re.search(r'\b(staging)\b', text, re.IGNORECASE):
            requirements['environment'] = 'staging'
        elif re.search(r'\b(production|prod)\b', text, re.IGNORECASE):
            requirements['environment'] = 'production'

        return requirements

    def generate_jenkinsfile(self, text):
        requirements = self.parse_requirements(text)
        stages = []

        if re.search(self.templates['build']['pattern'], text, re.IGNORECASE):
            stages.append(self.templates['build']['stage'].format(
                build_command=requirements['build_command']
            ))

        if re.search(self.templates['test']['pattern'], text, re.IGNORECASE):
            stages.append(self.templates['test']['stage'].format(
                test_command=requirements['test_command']
            ))

        if re.search(self.templates['deploy']['pattern'], text, re.IGNORECASE):
            stages.append(self.templates['deploy']['stage'].format(
                environment=requirements['environment'],
                deploy_command=requirements['deploy_command']
            ))

        jenkinsfile = f'''pipeline {{
            agent any
            stages {{
                {'\n'.join(stages)}
            }}
        }}'''

        return jenkinsfile

if __name__ == "__main__":
    generator = JenkinsfileGenerator()
    user_input = "Create a pipeline build and deploy the app to staging"
    print(generator.generate_jenkinsfile(user_input))
