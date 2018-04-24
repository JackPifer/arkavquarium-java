public class LinkedList<T> {
    private Node<T> first;

    public static void main(String args[]) {
        LinkedList<String> aa = new LinkedList<String>();
        System.out.println(aa.getSize());
        aa.add("Anjing");
        aa.add("babi");
        System.out.println(aa.getSize());
        aa.printList();
        System.out.println(aa.find("babi"));
        System.out.println(aa.get(1));
        aa.remove("babi");
        System.out.println(aa.getSize());
        aa.printList();
        System.out.println(aa.find("Anjing"));
        System.out.println(aa.isEmpty());
        aa.remove("Anjing");
        System.out.println(aa.isEmpty());
    }
     // Constructor LinkedList
    public LinkedList() {
        this.first = null;
    }

    // Geter
    public Node<T> getFirst() {
        return this.first;
    }

    // Mengembalikan nilai True jika linked list kosong dan false jika sebaliknya
    public boolean isEmpty() {
        return this.first == null;
    }

    public int getSize() {
        Node<T> curr = this.first;
        int count = 0;
        while(curr != null) {
            curr = curr.getNext();
            count++;
        }
        return count;
    }

    // Method ini menambahkan elemen sebagai elemen paling belakang pada LinkedList
    public void add(T element) {
        if (this.first == null) {
			this.first = new Node<T>(element);
			return;
		}

		Node<T> tmp = this.first;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}

		tmp.setNext(new Node<T>(element));
    }

    // Method ini mengembalikan indeks dimana elemen berada pada linked list dan -1 jika tidak ada
    public int find(T element){
        Node<T> curr = this.first;
        int count = 0;
        boolean found = false;
        while(!found && curr != null){
            if( curr.getValue() == element ) {
                found = true;
            } else {
                curr = curr.getNext();
            }
            count++;
        }
        if(curr.getValue() == element) {
            return count-1; 
        } else {
            return -1;
        }
    }

    // Method ini membuang elemen dengan identitas demikian
    public void remove(T element){
        Node<T> prec = null;
        Node<T> curr = this.first;
        Node<T> next;
        while(curr != null) {
            next = curr.getNext();
            if(curr.getValue() == element) {
                if(prec == null) {
                    first = next;
                } else {
                    prec.setNext(next);
                }
            } else {
                prec = curr;
            }
            curr = next;
        }
    }
// Method ini mengembalikan elemen dengan tipe T pada indeks ke-i.
    public T get(int index){
        if(this.getSize() <= index) {
            return null;
        }else if(index == 0) {
			// Get the first element
			return this.first.getValue();
		} else {
			// Get the index'th element
			Node<T> curr = this.first;
			for(int i = 0; i < index; ++i) {
				curr = curr.getNext();
			}
			return curr.getValue();
		}
    }
    
    public void printList() {
		if (this.first == null) {
			System.out.println("List is Empty !!");
			return;
		}
		Node<T> tmp = this.first;
		while (tmp != null) {
			System.out.println(tmp.getValue());
			tmp = tmp.getNext();
		}
    }
}

class Node<T> {
	private T value;
	private Node<T> next;

	public Node(T value) {
        this.value = value;
        this.next = null;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public T getValue() {
        return value;
    }

	public void setNext(Node<T> next) {
		this.next = next;
	}
}