// Problem: Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string;
// Solution: keep two pointer start and end, then swap the start and end until start meets end;

void reverse (char *str) {
	char* end = str;
	char temp;
	if (str) {
		while (*end) {
			++end;   // find the last pos
		}
		--end; // the end is '\0', so need to back one pos
		// swap start character and end character
		while (str < end) {
			temp = *str;
			*str++ = *end;
			*end-- = temp;
		}
	}
}