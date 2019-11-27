package datastructures.ListAndStackAndQueue;

/**
 * 手动实现二叉查找树
 * @author 潇潇暮雨
 *
 * @param <AnyType>
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	/** 定义一个二叉树节点类，和链表中的一样，是一个嵌套类*/
	private static class BinaryNode<AnyType> {
		// 节点元素
		AnyType element;
		// 元素的左节点
		BinaryNode<AnyType> left;
		// 元素的右节点
		BinaryNode<AnyType> right;

		BinaryNode(AnyType element) {
			this(element, null, null);
		}

		BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}

	/** 根节点*/
	private BinaryNode<AnyType> root;

	/** 初始化构造器，并将更加点置为空*/
	public BinarySearchTree() {
		this.root = null;
	}

	/** 将二叉树置为空*/
	public void makeEmpty() {
		root = null;
	}

	/**判断二叉树是否为空*/
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 *判断这棵树是否包含元素x 
	 * @param x
	 * @return
	 */
	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if (t.left == null && t.right == null) {
			return false;
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			return contains(x, t.left);
		} else if (compareResult > 0) {
			return contains(x, t.right);
		} else {
			return true;
		}
	}

	/**
	 *查找树的最小值 
	 * @return
	 */
	public AnyType findMin() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMin(root).element;
	}

	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t.left != null) {
			return findMin(t.left);
		} else {
			return t;
		}
	}

	/**
	 *将参数x插入到树中 
	 * @param x
	 */
	public void insert(AnyType x) {
		root = insert(x, root);
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null) {
			return new BinaryNode<AnyType>(x, null, null);
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		} else {
			; //插入的数据重复了，什么也不做。
		}
		return t;
	}

	/**
	 * 从树中删除x
	 * @param x
	 */
	public void remove(AnyType x) {
		root = remove(x, root);
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if (t == null) {
			return t;
		}
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			t.left = remove(x, t.left);
		} else if (compareResult > 0) {
			t.right = remove(x, t.right);
		} else if (t.left != null && t.right != null) //两个孩子
		{
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else {
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}

}
