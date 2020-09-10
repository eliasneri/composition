package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.Workerlevel;

public class Worker {
	
	private String name;
	private Workerlevel level;
	private Double baseSalary;
	
	// é uma associação para cada worker um departamento.
	private Department department; 		
	
	
	// uma associação em LISTA, porque para 1 worker pode haver vários contratos
	private List<HourContract> contracts = new ArrayList<>();
	
	
	public Worker() {
		
	}

	// não gerar o construtor utilizando a Lista
	// toda vez que na composição houver : "TEM MUITOS" não incluir a lista no construtor.
	public Worker(String name, Workerlevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Workerlevel getLevel() {
		return level;
	}

	public void setLevel(Workerlevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/*
	 * RETIRAR O SET CONTRACTS, A LISTA COMEÇA VAZIA, E PODE-SE ADICIONAR OU REMOVER CONTRATOS DA LISTA
	 * MAS NÃO PODE SUBSTITUIR ESSA LISTA
	 * 
	 * public void setContracts(List<HourContract> contracts) {
	 * 	this.contracts = contracts;
	 * }
	 * 
	 */
	
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
		// ADICIONEI UM NOVO CONTRATO NA MINHA LISTA DE CONTRATOSSSSS - ATENÇÃO COM O PLURAL
		// RECEBO O NOVO CONTRATO E ADICIONO EM UMA LISTA ONDE ESTÃO OS DEMAIS CONTRATOS.
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary; 
		Calendar cal = Calendar.getInstance();
		
		// para cada contrato c na lista de contratos faça
		for (HourContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year =  cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); // acrescentar 1+, porque os meses começam com 0 no Java
			
			// se o ano informado for igual ao ano na lista e o mês informado for igual ao mes informado na lista!
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
			
		}
		
		return sum;
	}
}
