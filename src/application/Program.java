package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.Workerlevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter Worker Data:");
		
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		// com esses dados já pode instaciar o trabalhador, classe Worker
		// Instancia uma nova classe Worker, passando o nome e 
		// enviando um objeto Enums, informando o nome, porisso o uso do valueOf
		// envia o baseSalary para o objeto Worker
		// cria um novo objeto Department, enviando o departamento q foi digitado.
		
		Worker worker = new Worker(workerName, Workerlevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? : ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerhour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			//Com esses Dados já pode iniciar o Objeto HourContract!
			// Instanciação
			
			HourContract contract = new HourContract(contractDate, valuePerhour, hours);
			//adicionando esse contrato para a lista de contratos do trabalhador!
			worker.addContract(contract);
		}

		sc.close();
		

	}

}
