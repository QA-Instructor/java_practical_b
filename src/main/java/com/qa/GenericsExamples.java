package com.qa;

import java.util.ArrayList;
import java.util.List;

public class GenericsExamples {
    public static void nonGenericListExample(){
        System.out.println("Example A: This is a non-generic example\n");
        List names = new ArrayList();
        names.add("Victoria");
        names.add("William");

        System.out.println("Note how the item needs to be downcast to a String");
        String name = (String) names.get(0);
        System.out.println("First name: " + name);

        System.out.println("\nUnfortunately, the compiler is happy to let you add anything to your name list,\nincluding numbers and booleans:");
        names.add(7);
        names.add(true);
        System.out.println(names);

        System.out.println("\nYou must remember to downcast the stored Object to a String, using\neither a cast or a call to toString()");
        String name2 = (String) names.get(1);
        String name3 = names.get(2).toString();
        System.out.println("Name 2: " + name2);
        System.out.println("Name 3: " + name3);
    }

    public static void genericListExample(){
        System.out.println("Example B: This is a generic example\n");

        List<String> names = new ArrayList();
        names.add("Rob");
        names.add("Sarah");

        System.out.println("Note how the item does NOT need to be downcast to a String");
        String name = names.get(0);
        System.out.println("First name: " + name);

        System.out.println("\nGenerics provide for strong type checking. Note the compiler warning when you uncomment the following code:");

//        uncomment / comment the below line
//        names.add(7);

        System.out.println("PROBLEM: java: incompatible types: int cannot be converted to java.lang.String");

        System.out.println("Cast the int to a String to enable it to be added to the list of names");
        names.add(String.valueOf(7));

        System.out.println("\nThe list can only have 'Strings' added to it:");
        System.out.println(names);
    }


    public static void nonGenericMethodExample() {
        System.out.println("Example C: This is a non-generic method example\n");

        System.out.println("3 non-generic arrays are created.\n");
        Character[] charArray = {'w', 'e', 'l', 'c', 'o', 'm', 'e'};
        Boolean[] boolArray = {true, false, true};
        Integer[] intArray = {1, 2, 3, 4, 5};

        System.out.println("Each array is converted to a list using a non-generic method.\n");
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());

        System.out.println("NOTE: because this does not use generics, there is no type-checking.");
        System.out.println("It is possible to assign a list of ints to a list of Strings");
        List<String> stringListOfInts = arrayToList(intArray, new ArrayList<>());

        System.out.println("Attempt to get the zeroth int from the INT list");
        System.out.println(intList.get(0));

        System.out.println("Attempt to get the zeroth int from the STRING list.\nThis results in a ClassCastException:");
        System.out.println(stringListOfInts.get(0));

    }
    // non generic method
    public static List arrayToList(Object[] array, List<Object> list) {
        for (Object object : array) {
            list.add(object);
        }
        return list;
    }

    // generic method - uses <T>
    public static <T> List<T> arrayToListGeneric(T[] array, List<T> list) {
        //    Useful if we want to be flexible about the types of objects we can pass in
        //    Put the type parameter before the method's return type
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    public static void genericMethodExample() {
        System.out.println("Example D: This is a generic method example\n");

        System.out.println("3 non-generic arrays are created.\n");
        Character[] charArray = {'w', 'e', 'l', 'c', 'o', 'm', 'e'};
        Boolean[] boolArray = {true, false, true};
        Integer[] intArray = {1, 2, 3, 4, 5};

        System.out.println("3 lists are created from the arrays using a generic method.\n");
        List<Character> charList = arrayToListGeneric(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToListGeneric(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToListGeneric(intArray, new ArrayList<>());

        System.out.println("NOTE: because this does use generics, there is strong type-checking.");
        System.out.println("It is NOT possible to assign a list of ints to a list of Strings\n");

//        uncomment / comment the following line
//        List<String> stringListOfInts = arrayToListGeneric(intArray, new ArrayList<>());
        // Try to get the zeroth value

        System.out.println("Attempt to get the zeroth item from each list and note no down-casting is required:");
        System.out.println("This is an INT in an INT array so no down-casting is required");
        int number = intList.get(0);
        System.out.println(number);

        System.out.println("Attempt to get the zeroth boolean from the BOOLEAN list");
        boolean value = boolList.get(0);
        System.out.println(value);

        System.out.println("Attempt to get the zeroth char from the CHAR list");
        char character = charList.get(0);
        System.out.println(character);
    }

}
