class Node<T> {
  private T value;
  private Node<T> next;

  /** 
   * constructor.
   * @param value value of node
   */
  public Node(T value) {
    this.value = value;
    this.next = null;
  }
  /** 
   * return next element (next node)
   * @return Object of Node
   */
  public Node<T> getNext() {
    return next;
  }

    /** 
   * getter.
   * @return value of current node.
   */
  public T getValue() {
    return value;
  }

    /** 
   * setter.
   * @param next set next property.
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }
}