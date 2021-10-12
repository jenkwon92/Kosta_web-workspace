package test;

public class Test2 {
	public static void passOne(Item item) {
		item.setName("SmartPhone");
	}

	public static void passTwo(Item item) {
		item = new Item("NoteBook");
	}

	public static void main(String[] args) {
		Item item = new Item("Car");
		passOne(item);
		System.out.print(item.getName() + ",");
		passTwo(item);
		System.out.print(item.getName());
	}
}
