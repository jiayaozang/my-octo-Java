 package com.zangjiayao.www;

import java.util.Scanner;

class Bank{
	public static String bankName;
	private String name;
	private String password;
	private double money;
	Scanner scanner=new Scanner(System.in);
	public Bank(String name,String password) {
		this.money=1000;
		this.name=name;
		this.password=password;
		System.out.println(name+"�����ɹ����˻�����ǣ�"+money);
	}
	public static void welcome() {
		System.out.println("��ӭ����"+bankName+"!");
	}
	public static void leave() {
		System.out.println("��ӭ�´ι���"+bankName+"!");
	}
	public  void setMoney(double money) {
		this.money+=money;
		System.out.println("�����"+money+"Ԫ����ǰ���Ϊ"+this.money+"Ԫ��");
	}
	public  void getMoney(String password,double money) {
		if(this.password.equals(password)) {
			if(this.money>=money) {
				this.money-=money;
				System.out.println("��ȡ��"+money+"Ԫ����ǰ���Ϊ"+this.money+"Ԫ��");
			}else {
				System.out.println("�������������룬��ǰ���Ϊ��"+this.money);
				double nextmoney=scanner.nextDouble();
				getMoney(this.password, nextmoney);
			}
		}else {
			System.out.println("������󣡻����������Ի��ᣡ���������룺");
			String nextpassword=scanner.next();
			if(this.password.equals(nextpassword)) {
				System.out.println("������ȷ��������ȡ���");
				if(this.money>=money) {
					this.money-=money;
					System.out.println("��ȡ��"+money+"Ԫ����ǰ���Ϊ"+this.money+"Ԫ��");
				}else {
					System.out.println("�������������룬��ǰ���Ϊ��"+this.money);
					double nextmoney=scanner.nextDouble();
					getMoney(this.password, nextmoney);
				}
			}else {
				System.out.println("������󣡻���һ�����Ի��ᣡ���������룺");
				String lastpassword=scanner.next();
				if(this.password.equals(lastpassword)) {
					System.out.println("������ȷ��������ȡ���");
					if(this.money>=money) {
						this.money-=money;
						System.out.println("��ȡ��"+money+"Ԫ����ǰ���Ϊ"+this.money+"Ԫ��");
					}else {
						System.out.println("�������������룬��ǰ���Ϊ��"+this.money);
						double nextmoney=scanner.nextDouble();
						getMoney(this.password, nextmoney);
						}
					}else {
						System.out.println("ȡ��ʧ�ܣ����п��Ѷ��ᣬ���뼤�������п�����˴����֤�������룡");
					}
			}
		}
	}
	public double Money() {
		return this.money;
	}
}
public class Bnaktest {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Bank.bankName="СС�רҵ�������";
		Bank.welcome();
		System.out.println("�������û����������п����룺");
		String nameString=scanner.next();
		String passwordString=scanner.next();
		Bank user1=new Bank(nameString, passwordString);
		while (true) {
			System.out.println("�𾴵�"+nameString+"�û���"+"�����ʻ���ǰ���Ϊ��"+user1.Money());
			System.err.println("1.���");System.err.println("2.ȡ��");System.err.println("3.�˳�ϵͳ");
			int a=scanner.nextInt();
			if(a==1) {
				System.out.println("���������");double money=scanner.nextDouble();
				user1.setMoney(money);
			}
			else if (a==2) {
				System.out.println("�����������ȡ����");
				String password=scanner.next();double money=scanner.nextDouble();
				user1.getMoney(password, money);
			}
			else if(a==3){
				Bank.leave();
				break;
			}else {
				System.out.println("������������ȷ������!");
			}

		}
		
	}

}
