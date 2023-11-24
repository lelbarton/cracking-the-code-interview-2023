# Question: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additonal data structures?

# Special cases
# Empty string => True

# Version one does not address the constraint of not using additional data structures
def is_all_unique_chars_v1(string: str) -> bool:
	if string == "":
		return True

	seen = set()
	for letter in string:
		if letter in seen:
			return False
		seen.add(letter)
	return True

assert is_all_unique_chars_v1(""), 'the empty string should return True'
assert is_all_unique_chars_v1('abcde'), 'abcde should return True'
assert not is_all_unique_chars_v1('aabcde'), 'aabcde should return False'
assert not is_all_unique_chars_v1('abcae'), 'abcae should return False'
assert not is_all_unique_chars_v1('abcae'), 'abcae should return False'
assert not is_all_unique_chars_v1('    '), '     (four spaces) should return False'
assert is_all_unique_chars_v1(' '), ' (one space) should return True'
assert is_all_unique_chars_v1(' 	'), ' 	(space tab) should return True'
assert is_all_unique_chars_v1('%^&*'), '%^&* should return True'
assert not is_all_unique_chars_v1('%^&%'), '%^&\% should return False'
assert is_all_unique_chars_v1('not@£abc'), 'not@£abc should return True'
assert not is_all_unique_chars_v1('not@£ab@'), 'not@£ab@ should return False'