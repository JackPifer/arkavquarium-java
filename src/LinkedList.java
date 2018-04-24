/** 
 * Represents a linkedlist
 * @version 1.0
 */
public class LinkedList<T> {
    private Node<T> first;

     // Constructor LinkedList
     /** 
     * constructor.
     */
    public LinkedList() {
        this.first = null;
    }

    // Geter
    /** 
     * getter.
     * @return Node.
     */
    public Node<T> getFirst() {
        return this.first;
    }

    // Mengembalikan nilai True jika linked list kosong dan false jika sebaliknya
    /** 
     * getter.
     * @return boolean.
     */
    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    /** 
     * getter.
     * @return integer.
     */
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
    /** 
     * Add to last element of linkedlist.
     * @param element element to add.
     */
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
    /** 
     * return index of element, or -1 if not available.
     * @param element element to find.
     * @return integer index of the specified element.
     */
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
    /** 
     * remove element from linkedlist.
     * @param element element to remove.
     */
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
    /**    
     * get element on index, if not available return null.
     * @param index of the element.
     * @return type of the element.
     */
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
    
    /** 
     * print element in linkedlist.
     */
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