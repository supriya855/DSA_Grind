SUBSTRING
=============
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring-int-int-
public String substring(int beginIndex,
                        int endIndex)
Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
Examples:

 "hamburger".substring(4, 8) returns "urge"
 "smiles".substring(1, 5) returns "mile"
 
Parameters:
beginIndex - the beginning index, inclusive.
endIndex - the ending index, exclusive.
Returns:
the specified substring.
Throws:
IndexOutOfBoundsException - if the beginIndex is negative, or endIndex is larger than the length of this String object, or beginIndex is larger than endIndex.

Math.min(), Math.max(), Arrays.fill();
  toCharArray
  =================
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#toCharArray--
public char[] toCharArray()
Converts this string to a new character array.
Returns:
a newly allocated character array whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string.
 
