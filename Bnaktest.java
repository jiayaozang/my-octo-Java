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
		System.out.println(name+"开户成功，账户余额是："+money);
	}
	public static void welcome() {
		System.out.println("欢迎光临"+bankName+"!");
	}
	public static void leave() {
		System.out.println("欢迎下次光临"+bankName+"!");
	}
	public  void setMoney(double money) {
		this.money+=money;
		System.out.println("你存了"+money+"元，当前余额为"+this.money+"元！");
	}
	public  void getMoney(String password,double money) {
		if(this.password.equals(password)) {
			if(this.money>=money) {
				this.money-=money;
				System.out.println("你取了"+money+"元，当前余额为"+this.money+"元！");
			}else {
				System.out.println("余额不足请重新输入，当前余额为："+this.money);
				double nextmoney=scanner.nextDouble();
				getMoney(this.password, nextmoney);
			}
		}else {
			System.out.println("密码错误！还有两次重试机会！请输入密码：");
			String nextpassword=scanner.next();
			if(this.password.equals(nextpassword)) {
				System.out.println("密码正确！请输入取款金额：");
				if(this.money>=money) {
					this.money-=money;
					System.out.println("你取了"+money+"元，当前余额为"+this.money+"元！");
				}else {
					System.out.println("余额不足请重新输入，当前余额为："+this.money);
					double nextmoney=scanner.nextDouble();
					getMoney(this.password, nextmoney);
				}
			}else {
				System.out.println("密码错误！还有一次重试机会！请输入密码：");
				String lastpassword=scanner.next();
				if(this.password.equals(lastpassword)) {
					System.out.println("密码正确！请输入取款金额：");
					if(this.money>=money) {
						this.money-=money;
						System.out.println("你取了"+money+"元，当前余额为"+this.money+"元！");
					}else {
						System.out.println("余额不足请重新输入，当前余额为："+this.money);
						double nextmoney=scanner.nextDouble();
						getMoney(this.password, nextmoney);
						}
					}else {
						System.out.println("取款失败，银行卡已冻结，若想激活请银行卡申办人带身份证重置密码！");
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
		Bank.bankName="小小臧专业理财银行";
		Bank.welcome();
		System.out.println("请输入用户姓名和银行卡密码：");
		String nameString=scanner.next();
		String passwordString=scanner.next();
		Bank user1=new Bank(nameString, passwordString);
		while (true) {
			System.out.println("尊敬的"+nameString+"用户，"+"您的帐户当前余额为："+user1.Money());
			System.err.println("1.存款");System.err.println("2.取款");System.err.println("3.退出系统");
			int a=scanner.nextInt();
			if(a==1) {
				System.out.println("请输入存款金额：");double money=scanner.nextDouble();
				user1.setMoney(money);
			}
			else if (a==2) {
				System.out.println("请输入密码和取款金额");
				String password=scanner.next();double money=scanner.nextDouble();
				user1.getMoney(password, money);
			}
			else if(a==3){
				Bank.leave();
				break;
			}else {
				System.out.println("请重新输入正确的数字!");
			}

		}
		
	}

}
