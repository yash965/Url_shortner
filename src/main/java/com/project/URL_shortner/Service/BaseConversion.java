package com.project.URL_shortner.Service;

public class BaseConversion {
    String base62String = "abcdefghiklmniopqrstuvwxyz0123456789ABCDEFGHIJKLMNIOPQRSTUVWXYZ";
    char[] allowedCharacters = base62String.toCharArray();
    int base = base62String.length();

    public String encode(Long input)
    {
        StringBuilder url = new StringBuilder();

        if(input == 0)
        {
            return String.valueOf(allowedCharacters[0]);
        }

        while(input > 0)
        {
            int rem = (int)(input % base);
            url.append(allowedCharacters[rem]);

            input = input/base;
        }

        return url.reverse().toString();
    }

    public long decode(String input)
    {
        long decoded = 0;

        for(int i=0; i<input.length(); i++)
        {
            decoded = (decoded * base) + base62String.indexOf(input.charAt(i));
        }

        return decoded;
    }
}
