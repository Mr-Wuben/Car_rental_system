/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：汽车管理类
 * 
*/

package Rent_car_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle_Manager {
	String no;// 汽车牌号
	String brand;// 汽车品牌
	String mtype;// 汽车类型
	String type;// 汽车型号
	String name;// 用户姓名
	int seatcount = 0;// 座位数
	int totalrent = 0;// 总租金
	int money = 0;// 分租金
	int days = 0;// 租赁天数
	int i = 0;// 循环变量
	static int j = 0;// 初始化界面执行次数控制函数

	Car car = new Car();// 新建对象car，为后期调用重写input做准备
	Bus bus = new Bus();// 新建对象bus，为后期调用重写input做准备
	Truck truck = new Truck();// 新建truck类，为后期调用重写input做准备
	List<Vehicle> vehicles = new ArrayList<Vehicle>();// 新建Arraylist类,对象名为vehicles，用来保存轿车、卡车和客车
	List<Customer> orders = new ArrayList<Customer>();// 新建Customer类，对象名为orders，用来保存用户租赁清单
	Customer p1 = new Customer();// 新建Customer对象p1，用来保存用户的租赁信息

	public void vehicle_init() {// 汽车初始化函数
		Vehicle car1 = new Car("浙0001", "宝马", "轿车", "550i", 0);// 新建父类Vehicle对象car1，调用子类有参构造函数，传入参数为车牌、品牌、汽车类型、具体型号、租赁状态
		Vehicle car2 = new Car("浙0002", "宝马", "轿车", "550i", 0);
		Vehicle car3 = new Car("浙0003", "宝马", "轿车", "550i", 0);
		Vehicle car4 = new Car("浙0004", "宝马", "轿车", "550i", 0);
		Vehicle car5 = new Car("浙0005", "别克", "轿车", "商务舱GL8", 0);
		Vehicle car6 = new Car("浙0006", "别克", "轿车", "商务舱GL8", 0);
		Vehicle car7 = new Car("浙0007", "别克", "轿车", "林荫大道", 0);
		Vehicle car8 = new Car("浙0008", "别克", "轿车", "林荫大道", 0);
		Vehicle truck1 = new Truck("浙0009", "重汽", "卡车", 10, 0);// 新建父类Vehicle对象truck1，调用子类有参构造函数，传入参数为车牌、品牌、汽车类型、吨数、租赁状态
		Vehicle truck2 = new Truck("浙0010", "重汽", "卡车", 20, 0);
		Vehicle truck3 = new Truck("浙0011", "解放", "卡车", 40, 0);
		Vehicle truck4 = new Truck("浙0012", "解放", "卡车", 50, 0);
		Vehicle bus1 = new Bus("浙0013", "金杯", "客车", 15, 0);// 新建父类Vehicle对象bus1，调用子类有参构造函数，传入参数为车牌、品牌、汽车类型、座位号、租赁状态
		Vehicle bus2 = new Bus("浙0014", "金杯", "客车", 40, 0);
		Vehicle bus3 = new Bus("浙0015", "金龙", "客车", 50, 0);
		Vehicle bus4 = new Bus("浙0016", "金龙", "客车", 60, 0);
		vehicles.add(car1);// 将初始化的对象添加到Arraylist对象vehicles中
		vehicles.add(car2);
		vehicles.add(car3);
		vehicles.add(car4);
		vehicles.add(car5);
		vehicles.add(car6);
		vehicles.add(car7);
		vehicles.add(car8);
		vehicles.add(bus1);
		vehicles.add(bus2);
		vehicles.add(bus3);
		vehicles.add(bus4);
		vehicles.add(truck1);
		vehicles.add(truck2);
		vehicles.add(truck3);
		vehicles.add(truck4);
	}

	public void system_start() {// 系统启动函数
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		if (j == 0) {// if里的字段只执行一次
			System.out.println("欢迎使用汽车租赁系统 Rev1.0");
			System.out.println("Powered by Jarvis,2020.10.21");
			for (i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");
			System.out.print("请输入您的姓名:");
			name = input.next();// 姓名
			j = 1;
		}
		System.out.print("请输入租赁天数：");
		days = input.nextInt();// 租赁天数
		System.out.print("请输入要租赁的汽车类型(1.轿车 2.客车 3.卡车):");
		mtype = input.next();// 汽车类型
		while (("1".equals(mtype) == false) && ("2".equals(mtype) == false) && ("3".equals(mtype) == false)) {
			System.out.print("没有这种类型的车辆,请重新输入：");
			mtype = input.next();// 汽车类型
		}
	}

	public void output_trolly(int start, int end) {// 打印购物清单
		int num = 1;// 序号变量
		for (i = 0; i < 20; i++)
			System.out.print("-");
		System.out.print("\n");
		System.out.println("您的订单如下:");
		System.out.println("[序号]\t[汽车牌号]\t[汽车类型]\t[汽车品牌]\t[汽车型号]\t[租赁天数]\t[租金]");
		for (i = start; i < end + 1; i++) {// 遍历Arraylist的对象orders，orders里存储用户的所有订购信息
			Customer person = (Customer) orders.get(i);
			totalrent = totalrent + person.getMoney();// 计算总租金
			System.out.printf("  %-8d%-15s%-15s%-12s%-18s%-15d%-8d\n", num, person.getNo(), person.getMtype(),
					person.getBrand(), person.getType(), person.getDays(), person.getMoney());
			num++;
		}
		System.out.println("\n" + "客户名：" + name + ",租赁总租金" + totalrent);// 打印客户名和总租金
	}

	public void menu() {// 系统菜单函数
		int trolly_start = 0;
		int trolly_end = 0;// 由于程序加入了不同客户订购不同的车辆，所以不同客户的购物车信息存储在rraylist型的orders不同的位置：trolly_start、trolly_end分别记录一个客户购物车信息的开始下标和结束下标
		int output_flag = 0;// 购物车输出控制变量
		int mistake = 0;// 输入错误反馈变量
		int times = 0;// 输入正确的第1组数据识别变量
		char cycle1 = 1;// 同一用户循环体控制变量
		char cycle2 = 1;// 不同用户循环体控制变量
		char confirm1 = 0;// cycle1、confirm1共同控制同一客户租赁多个汽车的循环
		char confirm2 = 0;// cycle2、confirm2共同控制不同客户租赁汽车的循环

		vehicle_init();// 汽车库初始化
		while (cycle2 == 1) {
			while (cycle1 == 1) {
				system_start();
				if ("1".equals(mtype)) {// 选择的是轿车,执行轿车输入函数
					mistake = car.input(brand, mtype, money, days, vehicles, orders, p1);
					if ((mistake == 0) && (times == 0)) {// 输入正确并且是排在正确输入中第一位的，使能输出，将输入正确的第1组数据识别变量=1
						output_flag = 1;
						times = 1;
					} else if ((mistake == 0) && (times != 0)) {// 其他输入正确将对应顾客的下标尾+1
						trolly_end++;
					} else// 输入错误不做任何操作
						;
				} else if ("2".equals(mtype)) {// 选择的是客车,执行客车输入函数
					mistake = bus.input(brand, mtype, money, days, vehicles, orders, p1);
					if ((mistake == 0) && (times == 0)) {
						output_flag = 1;
						times = 1;
					} else if ((mistake == 0) && (times != 0)) {
						trolly_end++;
					} else
						;
				} else if ("3".equals(mtype)) {// 选择的是卡车,执行卡车输入函数
					mistake = truck.input(brand, mtype, money, days, vehicles, orders, p1);
					if ((mistake == 0) && (times == 0)) {
						output_flag = 1;
						times = 1;
					} else if ((mistake == 0) && (times != 0)) {
						trolly_end++;
					} else
						;
				} else {
					System.out.println("没有这种类型的车辆");
				}
				System.out.println("请问还要继续租赁汽车么?(y OR press any key to exit)");// 输入y继续租赁，输入其他退出当前客户的租赁
				@SuppressWarnings("resource")
				Scanner input1 = new Scanner(System.in);
				confirm1 = input1.next().charAt(0);
				if (confirm1 != 'y') {// 不继续租赁车辆执行的操作
					cycle1 = 0;
				} else {// 继续租赁车辆执行的操作
					p1 = new Customer();// 选择继续租赁后,重新开辟空间,新建Customer类的对象p1,为接下来的信息录入做准备
				}
			}
			if (output_flag == 1) {// 如果输出使能，打印购物车
				output_trolly(trolly_start, trolly_end);
			}

			System.out.println("是否退出系统??(y OR press any key to continue)");
			@SuppressWarnings("resource")
			Scanner input2 = new Scanner(System.in);
			confirm2 = input2.next().charAt(0);
			if (confirm2 == 'y') {// 输入y退出系统，输入其他继续
				cycle2 = 0;
				System.out.println("退出系统成功！！");
			} else {// 切换不同用户时，需将所有标志变量复位到最初状态，将trolly_start、trolly_end在上一客户的基础上整体向下平移上一客户购物车长度，并且将trolly_start和trolly_end的下标置成相同
				if (times == 1) {// 依据times的值来判断是否要将下标平移，times==0的话，这个时候说明当前客户没有订购车辆，times==1的话，这个时候说明当前客户订购了车辆
					trolly_start = trolly_start + trolly_end + 1;// 根据数组下标初始为0的特点推导得到trolly_start = trolly_start
																	// +trolly_end + 1
					trolly_end = trolly_start;// 新的客户上下标必须一致才行
				}
				cycle1 = 1;
				times = 0;
				totalrent = 0;
				output_flag = 0;
				p1 = new Customer();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				System.out.print("请输入您的姓名:");
				name = input.next();// 姓名
			}
		}
	}
}
