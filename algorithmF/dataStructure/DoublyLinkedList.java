package dataStructure;

public class DoublyLinkedList<Item> {
	private Node head;
	private Node tail;
	private int size;
	
	class Node {
		Item value;
		Node prev;
		Node next;
 
		Node(Item v) {
			value = v;
		}
 
		public String toString() {
			return value.toString();
		}
	}
	
	public DoublyLinkedList() {
		head = new Node(null); 
		tail = new Node(null); 
		head.next = tail;
		tail.prev = head;
		size=0;
	}
	
	public boolean addFirst(Item o) {
		addAfter(new Node(o), head);
		return true;
	}
 
	public boolean addLast(Item o) {
		addBefore(new Node(o), tail);
		return true;
	}
 
	public boolean add(Item o) {
		return addLast(o);
	}
 
	public boolean add(int index, Item o) {
		addBefore(new Node(o), getNode(index));
		return true;
	}
 
	public boolean remove(int index) {
		removeNode(getNode(index));
		return true;
	}
 
	public boolean removeFirst() {
		removeNode(head.next);
		return true;
	}
 
	public boolean removeLast() {
		removeNode(tail.prev);
		return true;
	}
 
	public Item get(int index) {
		return getNode(index).value;
	}
 
	public int size() {
		return size;
	}
 
	public String toString() {
		StringBuffer s = new StringBuffer("[");
		Node node = head;
		for (int i = 0; i < size; i++) {
			node = node.next;
			if (i > 0)
				s.append(", ");
			s.append(node.value);
		}
		s.append("]");
		return s.toString();
	}
 
	// ������ʵ�ַ���
	private Node getNode(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node node = head.next;
		for (int i = 0; i < index; i++)
			node = node.next;
		return node;
	}
	
	
	private void addBefore(Node newNode, Node node) {
		newNode.next = node;
		newNode.prev = node.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	
	private void addAfter(Node newNode, Node node) {
		newNode.prev = node;
		newNode.next = node.next;
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		size++;
	}
	
	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
		size--;
	}
	
	
	public static void main(String [] args){
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		// ���
		dll.add("aaa");
		dll.add("bbb");
		dll.add("ccc");
		System.out.println(dll);
		// ��ӵ���ǰ
		dll.addFirst("AAA");
		System.out.println(dll);
		// ��ӵ����ͬ���
		dll.addLast("CCC");
		System.out.println(dll);
		// ��ӵ�ָ��λ��
		dll.add(4, "DDD");
		System.out.println(dll);
		// �Ƴ���ǰ��
		dll.removeFirst();
		System.out.println(dll);
		// �Ƴ�����
		dll.removeLast();
		System.out.println(dll);
		// �Ƴ�ָ��λ���ϵ�
		dll.remove(2);
		System.out.println(dll);
		// ����ָ��λ���ϵ�Ԫ��
		System.out.println(dll.get(1));
	}
	
}
