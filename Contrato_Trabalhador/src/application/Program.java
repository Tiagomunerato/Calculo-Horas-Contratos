package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import entities.enums.WorkerLevel;
import entities.HourContract;
import java.util.Scanner;

import entities.Department;
import entities.Worker;



public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do Departamento ");
		String departmentName = sc.nextLine();
		
		System.out.println("Digite dados do trabalhador: ");
		
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		
		System.out.print("Nivel: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Salario base: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName,WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departmentName));
		
		System.out.print("Quantos contratos para esse trabalhador");
		int n =sc.nextInt();
		
		for(int i = 1 ;i <= n; i++  ) {
			System.out.println("Entre com contrato " +i+ " data");
			System.out.print("Data (DD/MM/YY): ");
			
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Valor por Hora? ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duração em (horas)?");
			int hour = sc.nextInt();
			
			HourContract contract =	new HourContract(contractDate,valuePerHour,hour);
			worker.addContract(contract);
			
			
		}
		
		System.out.println();
		System.out.print("Entre com mes e ano para calcular (MM/AAAA): ");
		String monthAndYear =sc.next();
		int month = Integer.parseInt( monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println();
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento" + worker.getDepartment().getName());
		System.out.println("Resultado para "+monthAndYear+":"+ String.format("%.2f",worker.income(year, month)));
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		sc.close();
		

	}

}
