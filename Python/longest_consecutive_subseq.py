def longest_consecutive_subsequence(arr):
    num_set = set(arr)
    longest_length = 0

    for num in arr:
        if num - 1 not in num_set:
            current_num = num
            current_length = 1

            while current_num + 1 in num_set:
                current_num += 1
                current_length += 1

            longest_length = max(longest_length, current_length)

    return longest_length

# Test the function
if __name__ == "__main__":
    # Example array
    arr = [6, 5, 4, 3, 20]
    
    result = longest_consecutive_subsequence(arr)
    print(f"The length of the longest consecutive subsequence is: {result}\n")

    # Additional test cases
    test_cases = [
        [1, 9, 3, 10, 4, 20, 2],
        [36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42],
        [1],
        [1, 2, 3, 4, 5],
        [5, 4, 3, 2, 1],
        [1, 3, 5, 7, 9]
    ]

    for i, case in enumerate(test_cases, 1):
        result = longest_consecutive_subsequence(case)
        print(f"Test case {i}: {case}")
        print(f"Result: {result}\n")

