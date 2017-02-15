using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;

public class TextTransformer
{
    public static void Main()
    {
        const string CapturePattern = @"([$%&'])([^$%&']+)\1";

        var specialSymbolWeights = new Dictionary<char, int>
        {
            {'$', 1},
            {'%', 2},
            {'&', 3},
            {'\'', 4}
        };

        StringBuilder sb = new StringBuilder();

        string input = Console.ReadLine();
        while (input != "burp")
        {
            sb.Append(input);
            input = Console.ReadLine();
        }

        string text = Regex.Replace(sb.ToString(), @"\s+", " ");
        Regex stringMatcher = new Regex(CapturePattern);
        var matches = stringMatcher.Matches(text);

        StringBuilder result = new StringBuilder();

        foreach (Match match in matches)
        {
            char specialSymbol = match.Groups[1].Value[0];
            string capturedString = match.Groups[2].Value;
            int stringLength = capturedString.Length;

            for (int i = 0; i < stringLength; i++)
            {
                char currentSymbol = capturedString[i];
                char resultingChar;

                if (i % 2 == 0)
                {
                    resultingChar = (char)(currentSymbol + specialSymbolWeights[specialSymbol]);

                }
                else
                {
                    resultingChar = (char)(currentSymbol - specialSymbolWeights[specialSymbol]);
                }

                result.Append(resultingChar);
            }

            result.Append(" ");
        }

        Console.WriteLine(result);
    }
}