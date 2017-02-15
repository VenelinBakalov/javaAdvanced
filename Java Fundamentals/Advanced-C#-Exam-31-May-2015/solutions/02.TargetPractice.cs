namespace TargetPractice
{
    using System;

    public class TargetPractice
    {
        public static void Main()
        {
            string[] dimensions = Console.ReadLine().Split();
            string snake = Console.ReadLine();
            string[] shotParameters = Console.ReadLine().Split();

            int numberOfRows = int.Parse(dimensions[0]);
            int numberOfColumns = int.Parse(dimensions[1]);

            int impactRow = int.Parse(shotParameters[0]);
            int impactCol = int.Parse(shotParameters[1]);
            int shotRadius = int.Parse(shotParameters[2]);

            char[][] matrix = new char[numberOfRows][];

            FillMatrix(snake, matrix, numberOfColumns);

            FireAShot(matrix, impactRow, impactCol, shotRadius);

            DropCharacters(matrix);

            PrintMatrix(matrix);
        }

        private static void FillMatrix(string snake, char[][] matrix, int matrixWidth)
        {
            for (int i = 0; i < matrix.Length; i++)
            {
                matrix[i] = new char[matrixWidth];
            }

            bool isMovingLeft = true;
            int currentSymbolIndex = 0;

            for (int row = matrix.Length - 1; row >= 0; row--)
            {
                int col = isMovingLeft ? matrixWidth - 1 : 0;
                int colUpdate = isMovingLeft ? -1 : 1;

                while (0 <= col && col < matrixWidth)
                {
                    if (currentSymbolIndex >= snake.Length)
                    {
                        currentSymbolIndex = 0;
                    }

                    matrix[row][col] = snake[currentSymbolIndex];

                    currentSymbolIndex++;
                    col += colUpdate;
                }

                isMovingLeft = !isMovingLeft;
            }
        }

        private static void FireAShot(char[][] matrix, int impactRow, int impactCol, int shotRadius)
        {
            int matrixWidth = matrix[0].Length;

            for (int row = 0; row < matrix.Length; row++)
            {
                for (int col = 0; col < matrixWidth; col++)
                {
                    if (IsInsideRadius(row, col, impactRow, impactCol, shotRadius))
                    {
                        matrix[row][col] = ' ';
                    }
                }
            }
        }

        private static bool IsInsideRadius(int checkRow, int checkCol, int impactRow, int impactCol, int shotRadius)
        {
            int deltaRow = checkRow - impactRow;
            int deltaCol = checkCol - impactCol;

            bool isInRadius = deltaRow * deltaRow + deltaCol * deltaCol <= shotRadius * shotRadius;

            return isInRadius;
        }

        private static void DropCharacters(char[][] matrix)
        {
            int width = matrix[0].Length;

            for (int row = matrix.Length - 1; row >= 0; row--)
            {
                for (int column = 0; column < width; column++)
                {
                    if (matrix[row][column] != ' ')
                    {
                        continue;
                    }

                    int currentRow = row - 1;
                    while (currentRow >= 0)
                    {
                        if (matrix[currentRow][column] != ' ')
                        {
                            matrix[row][column] = matrix[currentRow][column];
                            matrix[currentRow][column] = ' ';
                            break;
                        }

                        currentRow--;
                    }
                }
            }
        }

        private static void PrintMatrix(char[][] matrix)
        {
            int matrixWidth = matrix[0].Length;

            for (int row = 0; row < matrix.Length; row++)
            {
                for (int col = 0; col < matrixWidth; col++)
                {
                    Console.Write(matrix[row][col]);
                }

                Console.WriteLine();
            }
        }
    }
}