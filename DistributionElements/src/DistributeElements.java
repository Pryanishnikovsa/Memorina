import java.util.Random;
import java.util.*;

class DistributeElements {

    private static int[][] CreateDistribution(int Length, int Width)
    {
        int dimension;
        int a,b,c,Random; // Счетчики циклов
        boolean d;
        Random rand = new Random();
        int[][] ResultTable;
        ResultTable = new int [Length][Width];

        // Т.к. у нас 2 пары, то создаю 2 списка в которые буду записывать значения из дипазона dimension
        // которые уже были присвоены. Нужно, чтобы не повторяться.
        ArrayList listA = new ArrayList<Integer>();
        ArrayList listB = new ArrayList<Integer>();

        //В переменную dimension рассчитываю диапазон из которого должно быть вычислиться случайное значение.
        // Для этого длина доски умножается на ширину (Length * Width). Т.к. мы должны собрать пары, то
        // полученное значение делится на 2. Далее т.к. функция rand.nextInt при расчете случайного
        // числа в т.ч. использует 0 (можно задать только верхнюю границу диапазона из которого будет вычис-
        // ляться случайное значение, то от полученного значения dimension нужно отнять 1. Далее мы эту едини-
        // цу прибавим после вычисления случайного значения, чтобы у нас никогда не выпадал 0.
        //
        dimension = ((Length * Width) / 2)-1;

        // В цикле перебираем все ячейки доски (сначала Lentgth, а затем Width)
        for(a=1; a <= Length; a++){
            for(b=1; b <= Width; b++){

                // Вычисляем случайное значение из заданного верхнего диапазона. А чтобы не выпал 0 прибав-
                //ляем к нему единицу.
                Random = rand.nextInt(dimension)+1;

                // Создаю бесконечный цикл выход из которого будет осуществлен только после того как
                // для текущей ячейки (текущее значение Length и Width) будет подобрано значение
                // в этом случае переменной d будет присвоено значение true и произойдет выход из цикла
                d = false;
                while(d != true){

                    // Для полученного случайного числа Random организую цикл от числа Random и до верхней
                    // границы множества (dimension).
                    for (c = Random;c<=dimension+1;c++){
                        // Проверяю не содержится ли число 'c' в списке первых пар (listA). Если не содер-
                        // жится, то добавляю, иначе проверяю нельзя ли его добавить в список вторых пар.
                        // Как только найдено не занятое значение - пишу его в результирующую таблицу и
                        // выхожу из цикла.
                        if (listA.contains(c) == false){
                            listA.add(c);
                            d = true;

                            ResultTable[a-1][b-1] = c;
                            break;
                        }
                        if (listB.contains(c) == false){
                            listB.add(c);
                            d = true;
                            ResultTable[a-1][b-1] = c;
                            break;
                        }
                    }

                    // Если перебор от 'c' до верхней границы множества не помог (уже все значения заняты)
                    // то перебираю нижний диапазон значений (от 1 до 'c').
                    // Логика добавления значений в результирующую таблицу такая же как для кода выше.

                    if (d == false){
                        for (c = 1;c<=Random;c++){
                            if (listA.contains(c) == false){
                                listA.add(c);
                                d = true;
                                ResultTable[a-1][b-1] = c;
                                break;
                            }
                            if (listB.contains(c) == false){
                                listB.add(c);
                                d = true;
                                ResultTable[a-1][b-1] = c;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Возвращаю из функции результирующую таблицу результата
        return ResultTable;
    }

    public static void main(String[] args) {
        int[][] ResultTable; // Двумерный массив с результатом
        int Length, Width; // Переменные длина и ширина поля
        int a,b; // Счетчики циклов

        // Задаем длину и ширину доски
        Length = 2;
        Width = 6;

        // Получаем таблицу с результатом1
        ResultTable = CreateDistribution(Length, Width);

        // Выводим результат на экран
        for(a=0; a <= Length-1; a++){
            for(b=0; b <= Width-1; b++){
                System.out.print(ResultTable[a][b] + ";");
            }
            System.out.println("");
        }
    }



}
