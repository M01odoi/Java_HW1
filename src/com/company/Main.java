package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
//task 0
        int input = 454;
        String task0Result = task0(input);
        System.out.println("Result of task 0: "+task0Result);
//task 1
        input = 111011;
        int task1Result = task1(input);
        System.out.println("Result of task 1: "+ task1Result);
//task 2
        int[] task2Result = task2(new int[100]);
        System.out.println("Result of task 2: " + Arrays.toString(task2Result));
//task 2+
        int lengthOfArray = 13;
        int[] task2AddResult = task2Plus(lengthOfArray);
        System.out.println("Result of task 2 add: "+Arrays.toString(task2AddResult));
//task 3
        int lengthArray3 = 10; //told every task create independent variables
        int[] array = new int[lengthArray3];
        for (int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*100+1);
        }
        double avgOfArray = task3(array);
        System.out.println("Random array for next task 3: "+Arrays.toString(array));
        System.out.println("Result of task 3: "+avgOfArray);
//task 3+
        int lengthArray31 = 5; //told every task create independent variables
        int[] array3add = new int[lengthArray31];
        for (int i=0;i<array3add.length;i++){
            array3add[i]=(int)(Math.random()*100+1);
        }
        double avgGeom = task3Add1(array3add);
        System.out.println("Random array for next task 3.1: "+Arrays.toString(array3add));
        System.out.println("Result of task 3.1: "+avgGeom);
//task 3++
        int lengthArray32 = 5; //told every task create independent variables
        double[] avg = task3Add2(lengthArray32);
        System.out.println("Result of task 3.2: avg = "+avg[0]+"; avg Geom = "+avg[1]);
//task 4
        int[] array4 = new int[]{55, 42, 16, 877,2002,1,1,3, 24, 62, 56};
        int[] arr= task4(array4);
        System.out.println("Result of task 4: "+Arrays.toString(arr));
//task 4+ bogosort
        int[] array4_1 = new int[]{13,1,32,12,5,32,55,12};
        task4Add1(array4_1);
        System.out.println("Result of task 4.1 (bogosort): "+ Arrays.toString(array4_1));

//task 4++ quick sort
        int[] array4_2 = new int[]{1,10,0,14,27,4,9,8};
        int low = 0;
        int high = array4_2.length-1;
        task4_2(array4_2,low,high);
        System.out.println("Result of task 4_2: "+Arrays.toString(array4_2));

//task 5
        String str = "Java School allows you to try java programming language on practice. Java one of the most popular programming languages. I love Java!!!";
        String substr = "Java";
        int a = task5(substr, str);
        System.out.println("Result of task 5: " + a);

//task 5_1
         str = "Java School allows you to try java programming language on practice. Java one of the most popular programming languages. I love Java!!!";
         substr = "Java";
         int[] includes = task5_1(substr,str);
        System.out.println("Result of task 5_1: "+ Arrays.toString(includes));

//task 5_2
        System.out.println("Result of task 5_2 (how much search text includes in text): "+ task5_2());

//optional Task 1
        int[] weather = optionalTask1();
        int index =0;
        System.out.println("Result of optional task 1: "+Arrays.toString(weather));
        for (int el:weather){
            System.out.println(++index+" день, "+el+" градусов;");
        }
//optional Task 2
        System.out.println("Result of optional task 2. optionalTask2(-34) = " + Arrays.toString(optionalTask2(-34)));
        System.out.println("Result of optional task 2. optionalTask2(TypesOfWeather.Hot) = " + Arrays.toString(optionalTask2(TypesOfWeather.Hot)));
        System.out.println();

//optional Task 3
        System.out.println("Result of optional task 3");
        optionalTask3(2);

        System.out.println(System.currentTimeMillis() - time + " milliseconds");
    }

    public static String task0(int input) {
        return String.valueOf(input);
    }

    public static int task1(int numb) {
        int sum = 0;
        while (numb > 0) {
            sum += numb % 10;
            numb = numb / 10;
        }
        return sum;
    }

    public static int[] task2(int[] simpleNumb) {
        int simple = 2;
        int indexOfArray = 0;
        boolean isSimple = true;
        while (indexOfArray < simpleNumb.length) {
            for (int i = 2; i < simple; i++) {
                if (simple % i == 0) {
                    isSimple = false;
                    break;
                } else isSimple = true;
            }
            if (isSimple) {
                simpleNumb[indexOfArray] = simple;
                ++indexOfArray;
            }
            simple += 1;
        }

        return simpleNumb;
    }

    public static int[] task2Plus(int lengthArray) {
        int[] arrayOfSimpleNumb = new int[lengthArray];
        return task2(arrayOfSimpleNumb);
    }

    public static double task3(int[] randomArray) {
        double sum = 0;
        double avg;
        for (int elementOfArray : randomArray) {
            sum += elementOfArray;
        }
        avg = sum / randomArray.length;
        return avg;
    }

    public static double task3Add1(int[] randomArray) {
        double multiply = 1;
        double avgGeom;
        for (int elementOfArray : randomArray) {
            multiply *= elementOfArray;
        }
        avgGeom = Math.pow(multiply, 1.0 / randomArray.length);
        return avgGeom;
    }

    public static double[] task3Add2(int lengthOfArray) {
        int[] randomArray = new int[lengthOfArray];
        double[] avg = new double[2];
        Scanner sc = new Scanner(System.in);
        for (int elementofArray = 0; elementofArray < randomArray.length; elementofArray++) {
            System.out.println("Input " + elementofArray + " element of array: ");
            randomArray[elementofArray] = sc.nextInt();
        }
        avg[0] = task3(randomArray);
        avg[1] = task3Add1(randomArray);
        System.out.println("Input array: " + Arrays.toString(randomArray));
        return avg;
    }

    public static int[] task4(int[] array) {
        int[] arr = new int[array.length];
        System.arraycopy(array, 0, arr, 0, array.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        return arr;
    }

    public static int[] task4Add1(int[] array) {
        if (Arrays.equals(task4(array), array)) {
            return array;
        } else {
            shuffleArray(array);
            return task4Add1(array);
        }
    }

    public static void shuffleArray(int[] arr) {
        int n = arr.length;
        Random rand = new Random();
        for (int i = 1; i < n; i++) {
            int change = rand.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[change];
            arr[change] = temp;
        }
    }

    public static void task4_2(int[] arr, int low, int high) {
        if (arr.length == 0)
            return;
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        int opora = arr[mid];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < opora) i++;
            while (arr[j] > opora) j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) task4_2(arr, low, j);
        if (high > i) task4_2(arr, i, high);
    }

    public static int task5(String substr, String str) {
        substr = substr.toLowerCase();
        str = str.toLowerCase();
        int count = 0;
        while (str.contains(substr)) {
            int firstLetter = str.indexOf(substr);
            int lastLetter = substr.length();
            str = str.substring(firstLetter + lastLetter);
            count++;
        }
        return count;
    }

    public static int[] task5_1(String substr, String str) {
        substr = substr.toLowerCase();
        str = str.toLowerCase();
        int length = task5(substr, str);
        int[] indexOfinclude = new int[length];
        int i = 0, lastIndex = 0;
        while (i != length) {
            indexOfinclude[i] = str.indexOf(substr, lastIndex);
            lastIndex = indexOfinclude[i] + 1;
            i++;
        }
        return indexOfinclude;
    }

    public static int task5_2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input text: ");
        String str = sc.nextLine();
        System.out.println("Input search text: ");
        String substr = sc.nextLine();
        return task5(substr, str);
    }

    public static int[] optionalTask1() {
        int[] weather = new int[29];
        for (int el = 0; el < weather.length; el++) {
            weather[el] = (int) (Math.random() * 200 - 100);

        }
        return weather;
    }

    enum TypesOfWeather {
        Frost,
        Cool,
        Warm,
        Hot
    }
    public static String[] optionalTask2(int temp) {
        TypesOfWeather weather;
        if (temp < -50) weather = TypesOfWeather.Frost;
        else if (temp < 0) weather = TypesOfWeather.Cool;
        else if (temp < 50) weather = TypesOfWeather.Warm;
        else weather = TypesOfWeather.Hot;

        return optionalTask2(weather);
    }
    public static String[] optionalTask2(TypesOfWeather weather) {
        String[] clothes = new String[2];
        switch (weather) {
            case Frost:
                clothes[0] = "Шуба";
                clothes[1] = "Теплые ботинки";
                break;
            case Cool:
                clothes[0] = "Куртка";
                clothes[1] = "Ботинки";
                break;
            case Warm:
                clothes[0] = "Футболка";
                clothes[1] = "Штаны";
                break;
            case Hot:
                clothes[0] = "Майка";
                clothes[1] = "Шорты";
                break;
        }
        return clothes;
    }

    public static void optionalTask3(int days) {
        if (days<30){
        int[] weather = optionalTask1();
        int[] daysWeather = Arrays.copyOf(weather,days);
        int index = 1;
        for (int el: daysWeather){
        String[] clothes = optionalTask2(el);
            System.out.println("Day "+index+": "+daysWeather[index-1]+", "+Arrays.toString(clothes));
            index++;
        }}
        else {
            System.out.println("Incorrect input, 0<day<30");
        }
    }
}
