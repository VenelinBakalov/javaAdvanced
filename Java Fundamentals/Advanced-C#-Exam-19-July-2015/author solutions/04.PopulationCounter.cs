namespace PopulationCounter
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class PopulationCounter
    {
        public static void Main()
        {
            var populationData = new Dictionary<string, Dictionary<string, long>>();

            string input = Console.ReadLine();

            while (input != "report")
            {
                string[] data = input.Split('|');
                string country = data[1];
                string city = data[0];
                int population = int.Parse(data[2]);

                if (!populationData.ContainsKey(country))
                {
                    populationData.Add(country, new Dictionary<string, long>());
                }

                populationData[country].Add(city, population);

                input = Console.ReadLine();
            }

            var sortedPopulationData = populationData
                .OrderByDescending(x => x.Value
                    .Sum(y => y.Value));

            foreach (var countryInfo in sortedPopulationData)
            {
                long totalPopulation = countryInfo.Value.Sum(x => x.Value);
                Console.WriteLine(
                    "{0} (total population: {1})", 
                    countryInfo.Key, 
                    totalPopulation);

                var orderedCityData = countryInfo.Value
                    .OrderByDescending(x => x.Value);

                foreach (var cityInfo in orderedCityData)
                {
                    Console.WriteLine("=>{0}: {1}", cityInfo.Key, cityInfo.Value);
                }
            }
        }
    }
}
