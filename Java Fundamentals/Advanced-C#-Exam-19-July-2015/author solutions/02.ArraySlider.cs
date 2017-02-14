namespace ArraySlider
{
    using System;
    using System.Linq;
    using System.Numerics;

    public class ArraySlider
    {
        public static void Main()
        {
            BigInteger[] array = Console.ReadLine()
                .Split(new []{' ', '\t'}, StringSplitOptions.RemoveEmptyEntries)
                .Select(BigInteger.Parse)
                .ToArray();

            string command = Console.ReadLine();
            int currentIndex = 0;

            while (command != "stop")
            {
                string[] commandParams = command.Split();
                int offset = int.Parse(commandParams[0]) % array.Length;
                string operation = commandParams[1];
                int operand = int.Parse(commandParams[2]);

                if (offset < 0)
                {
                    offset += array.Length;
                }

                currentIndex = (currentIndex + offset) % array.Length;

                PerformOperation(operation, array, currentIndex, operand);

                command = Console.ReadLine();
            }

            Console.WriteLine("[{0}]", string.Join(", ", array));
        }

        private static void PerformOperation(string operation, BigInteger[] array, int currentIndex, int operand)
        {
            switch (operation)
            {
                case "&":
                    array[currentIndex] &= operand;
                    break;
                case "|":
                    array[currentIndex] |= operand;
                    break;
                case "^":
                    array[currentIndex] ^= operand;
                    break;
                case "+":
                    array[currentIndex] += operand;
                    break;
                case "-":
                    array[currentIndex] -= operand;
                    break;
                case "*":
                    array[currentIndex] *= operand;
                    break;
                case "/":
                    array[currentIndex] /= operand;
                    break;
            }

            if (array[currentIndex] < 0)
            {
                array[currentIndex] = 0;
            }
        }
    }
}
