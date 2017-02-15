using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class OlympicsAreComing
{
    public static void Main()
    {
        const string SplitPattern = @"\s*\|\s*";
        Regex regex = new Regex(SplitPattern);

        var countryData = new Dictionary<string, List<string>>();

        string input = Console.ReadLine();

        while (input != "report")
        {
            string[] tokens = regex.Split(input.Trim());
            string athlete = Regex.Replace(tokens[0].Trim(), @"\s+", " ");
            string country = Regex.Replace(tokens[1].Trim(), @"\s+", " ");

            if (!countryData.ContainsKey(country))
            {
                countryData.Add(country, new List<string>());
            }

            countryData[country].Add(athlete);

            input = Console.ReadLine();
        }

        var orderedCountryData = countryData
            .OrderByDescending(x => x.Value.Count);

        foreach (var country in orderedCountryData)
        {
            Console.WriteLine(
                "{0} ({1} participants): {2} wins",
                country.Key,
                country.Value.Distinct().Count(),
                country.Value.Count);
        }
    }
}