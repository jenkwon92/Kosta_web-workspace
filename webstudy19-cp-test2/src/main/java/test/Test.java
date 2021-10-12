package test;

class Item {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Test {
	public static void passOne(Item item) {
		item.setName("SmartPhone");
	}

	public static void passTwo(Item item) {
		item = new Item("NoteBook");
	}

	public static void main(String[] args) {
		Item item = new Item("Car");
		passOne(item);
		System.out.print(item.getName() + ","); //SmartPhone, 
		passTwo(item);
		System.out.print(item.getName());
	}
}
