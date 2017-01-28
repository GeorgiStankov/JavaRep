package week04;

import java.util.List;

public class MyBST<T extends Comparable<T>> implements MyBSTInterface<T> {

	public Node root;

	public MyBST() {
		this.root = null;
	}

	public class Node {
		T data;
		Node left;
		Node right;

		public Node(T data) {
			this.data = data;
			left = null;
			right = null;

		}

		public Node(Node node) {
			this.data = node.data;
			left = null;
			right = null;

		}

		public Node(T data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;

		}
	}

	public Node build(List<Integer> list) {
		if (list.isEmpty()) {
			return null;

		}
		int middle = list.size() / 2;
		T value = (T) list.get(middle);
		Node left = build(list.subList(0, middle));
		Node right = build(list.subList(middle + 1, list.size()));
		return new Node(value, left, right);
	}

	public int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public void print() {
		if (root != null) {
			if (root.left != null)
				System.out.println(root.left.data);
			if (root.right != null)
				System.out.println(root.right.data);
		}

	}

	@Override
	public void insert(T element) {
		Node node = new Node(element);

		if (root == null) {
			root = new Node(element);

		} else {
			insertRec(root, node);
		}

	}

	private void insertRec(Node latestRoot, Node node) {

		if ((latestRoot.data).compareTo(node.data) < 0) {

			if (latestRoot.left == null) {
				latestRoot.left = new Node(node);
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = new Node(node);

			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	@Override
	public boolean find(T element) {
		boolean isFound = false;
		Node node = null;
		if (root != null) {
			node = root;

		}
		isFound = findRec(node, element);
		return isFound;

	}

	private boolean findRec(Node node, T element) {

		if (node.data == element) {
			return true;
		}

		else if ((node.data).compareTo(element) < 0) {

			if (node.left == null) {
				return false;
			} else {

				if (node.left.data.compareTo(element) == 0) {
					return true;
				} else {
					node = node.left;
					return findRec(node, element);

				}
			}
		} else {
			if (node.right == null) {
				return false;
			} else {

				if (node.right.data == element) {
					return true;
				} else {
					node = node.right;
					return findRec(node, element);
				}
			}
		}

	}

	@Override
	public void remove(T element) {
		Node targetNode = findT(element);
		if (element != null && root != null) {
			Node node = root;
			removeRec(node, element);
		}

	}

	private Node findT(T target) {
		if (root == null) {
			return null;
		} else {
			if (target.compareTo(root.data) < 0) {
				// go left
			} else {
				// go right
				return null;
			}
		}
		return root;
	}

	private void removeRec(Node latestRoot, T element) {

	}

}
