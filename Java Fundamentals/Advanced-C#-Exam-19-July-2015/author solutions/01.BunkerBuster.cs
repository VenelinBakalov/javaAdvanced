namespace BunkerBuster
{
    using System;

    public class BunkerBuster
    {
        public static void Main()
        {
            string[] dimensions = Console.ReadLine().Split();
            int numberOfRows = int.Parse(dimensions[0]);
            int numberOfColumns = int.Parse(dimensions[1]);

            int[,] field = new int[numberOfRows, numberOfColumns];

            InitField(numberOfRows, numberOfColumns, field);

            string command = Console.ReadLine();
            ProcessBombardment(command, field, numberOfRows, numberOfColumns);

            int destroyedBunkers = GetDestroyedBunkersCount(field);
            double totalDamage = (double)destroyedBunkers / field.Length;

            Console.WriteLine("Destroyed bunkers: {0}", destroyedBunkers);
            Console.WriteLine("Damage done: {0:P1}", totalDamage);
        }

        private static void InitField(int numberOfRows, int numberOfColumns, int[,] field)
        {
            for (int i = 0; i < numberOfRows; i++)
            {
                string[] cellInfo = Console.ReadLine().Split();

                for (int j = 0; j < numberOfColumns; j++)
                {
                    field[i, j] = int.Parse(cellInfo[j]);
                }
            }
        }

        private static void ProcessBombardment(string command, int[,] field, int numberOfRows, int numberOfColumns)
        {
            while (command != "cease fire!")
            {
                string[] commandArgs = command.Split();
                int impactRow = int.Parse(commandArgs[0]);
                int impactCol = int.Parse(commandArgs[1]);
                int bombPower = char.Parse(commandArgs[2]);

                field[impactRow, impactCol] -= bombPower;

                int reducedBombPower = (int)Math.Ceiling(bombPower / 2.0);

                ExplodeAdjacentCells(field, numberOfRows, numberOfColumns, impactRow, impactCol, reducedBombPower);

                command = Console.ReadLine();
            }
        }

        private static void ExplodeAdjacentCells(int[,] field, int numberOfRows, int numberOfColumns, int impactRow,
            int impactCol, int bombPower)
        {
            int startRow = Math.Max(0, impactRow - 1);
            int endRow = Math.Min(impactRow + 1, numberOfRows - 1);
            int startCol = Math.Max(0, impactCol - 1);
            int endCol = Math.Min(impactCol + 1, numberOfColumns - 1);

            for (int row = startRow; row <= endRow; row++)
            {
                for (int col = startCol; col <= endCol; col++)
                {
                    if (row == impactRow && col == impactCol)
                    {
                        continue;
                    }

                    field[row, col] -= bombPower;
                }
            }
        }

        private static int GetDestroyedBunkersCount(int[,] field)
        {
            int destroyedBunkers = 0;

            foreach (var cell in field)
            {
                if (cell <= 0)
                {
                    destroyedBunkers++;
                }
            }

            return destroyedBunkers;
        }
    }
}