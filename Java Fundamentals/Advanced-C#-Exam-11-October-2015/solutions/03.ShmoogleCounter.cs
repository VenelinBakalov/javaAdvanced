using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class ShmoogleCounter
{
    static void Main()
    {
        var rgx = new Regex("(double|int)\\s+([a-z][a-zA-Z]*)");
        var ints = new List<string>();
        var doubles = new List<string>();

        string input;
        while (!(input = Console.ReadLine()).StartsWith("//"))
        {
            var variables = rgx.Matches(input);
            foreach (Match variable in variables)
            {
                var type = variable.Groups[1].Value;
                var name = variable.Groups[2].Value;
                if (type == "double")
                {
                    doubles.Add(name);
                }
                else
                {
                    ints.Add(name);
                }
            }
        }

        Console.WriteLine("Doubles: {0}", FormatOutput(doubles));
        Console.WriteLine("Ints: {0}", FormatOutput(ints));
    }

    private static string FormatOutput(ICollection<string> vars)
    {
        return vars.Count > 0 ? string.Join(", ", vars.OrderBy(v => v)) : "None";
    }
}