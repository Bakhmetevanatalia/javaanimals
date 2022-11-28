import animals.Animal;
import animals.birds.Duck;
import animals.pet.Cat;
import animals.pet.Dog;
import data.AnimalTypeData;
import data.CommandsData;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Animal> Animals = new ArrayList<Animal>();
        Scanner in = new Scanner(System.in);
        CommandsData comma = null;
        AnimalTypeData animalType = null;

        while (comma != CommandsData.EXIT){
            comma = null;
            while (comma == null){
                System.out.println("Введите комманду add/list/exit");
                try{
                    String Scomma = in.next().toUpperCase();
                    comma = CommandsData.valueOf(Scomma);
                } catch (IllegalArgumentException e){
                    System.out.println("Ошибка ввода");
                }
            }
            if (comma == CommandsData.ADD){
                
                animalType = null;
                while (animalType == null){
                    System.out.println("Введите животное cat/dog/duck");
                    try{
                        String anml = in.next().toUpperCase();
                        animalType = AnimalTypeData.valueOf(anml);
                    } catch (IllegalArgumentException e){
                        System.out.println("Ошибка ввода");
                    }
                }
                String name, color;
                Integer age, weight;
                System.out.print("Введите имя животного ");
                name = in.next();
                System.out.print("Введите цвет животного ");
                color = in.next();
                System.out.print("Введите возраст животного ");
                age = getInt(in);
                System.out.print("Введите вес животного ");
                weight = getInt(in);
                if (animalType == AnimalTypeData.CAT){
                    Cat a = new Cat(name, color, age, weight);
                    a.Say();
                    Animals.add(a);
                }else if(animalType == AnimalTypeData.DOG){
                    Dog a = new Dog(name, color, age, weight);
                    a.Say();
                    Animals.add(a);
                }else if(animalType == AnimalTypeData.DUCK){
                    Duck a = new Duck(name, color, age, weight);
                    a.Say();
                    Animals.add(a);
                }   
                
            }
            else if (comma == CommandsData.LIST){
                if (Animals.size() == 0) System.out.println("В списке нет животных");
                else for (Animal a: Animals) System.out.println(a);
            }
        
        }   
    }

    static Integer getInt(Scanner sc){
        int i;
        while (true) {
            try {
                i = Integer.parseInt(sc.next());
                if (i <= 0){
                    System.out.println("Неверный ввод!");
                    continue;}
                else{return i;}

            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
}
