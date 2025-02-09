# pip install langchain-community
# pip install langchain huggingface_hub
#pip install -U langchain-huggingface
# Import necessary modules
import time
from langchain_community.llms import HuggingFaceHub  
from langchain.prompts import PromptTemplate 
from langchain.chains import LLMChain 
from langchain_huggingface import HuggingFaceEndpoint 


# Set up Hugging Face model
# Replace 'your-huggingface-api-token' with your actual Hugging Face API token
HUGGINGFACE_API_TOKEN =  "your_tokenh"

def prompt(topic):
    # Initialize the Hugging Face model
    # You can replace 'gpt2' with any other model from Hugging Face Hub
    llm = HuggingFaceHub(
        repo_id="Salesforce/codegen-350M-mono",  # Model repository ID
        huggingfacehub_api_token=HUGGINGFACE_API_TOKEN,
        model_kwargs={"temperature": 0.7, "max_length": 50}  # Adjust parameters as needed
    )
    prompt = PromptTemplate(
        input_variables=["topic"],
        template="Write a program in Java for  {topic}."
    )
    chain = prompt | llm
    response = chain.invoke(topic)
    return f"Generated code:{response}"

if __name__ == "__main__":
    text = "is string palindrome or not"
    huggingface_response = prompt(text)
    if huggingface_response:
        print("Hugging Face Response:\n", huggingface_response)
