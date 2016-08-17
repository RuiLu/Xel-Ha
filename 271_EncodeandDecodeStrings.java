/**
 *  Encoding -> <string.length()> + </> + <string>
 *  Example -> <string> -> <6/string>
 */ 
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i); // from index i, search the first index that contains "/"
            int length = Integer.parseInt(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + length + 1));
            i = slash + length + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
