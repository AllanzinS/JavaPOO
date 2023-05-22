package exemplos_aula;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import construtores.product;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);

		List<product> list = new ArrayList<>();


		System.out.print("How many employees will be registered?");
		int quantidade = sc.nextInt();

		for (int i = 1; i<=quantidade; i++) { 
			System.out.println("Employee #" + i + ":");
			System.out.print("Id:");
			sc.nextLine();
			Integer id = sc.nextInt();
			System.out.print("Name:");
			String name = sc.next();
			System.out.print("Salary:");
			double salary = sc.nextDouble();

			product product = new product(id, name, salary);
			//Momento onde instanciamos um objeto e o adicionamos no sistema de listas.
			list.add(product);
		}

		System.out.println("Enter the employee id that will have salary increase:");
		int numero = sc.nextInt();
		Integer pos = position(list, numero);
		if (pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}

		System.out.println("List of employees");
		for (product product : list) {
			System.out.println(product);
		}
		
		sc.close();
		
	}

	public static Integer position(List<product> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
        //Fórmula usada para procurar o ID do usuário com arrayList
			}
		}
		return null;
	}

}

