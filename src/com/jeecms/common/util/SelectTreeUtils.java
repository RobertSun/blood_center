package com.jeecms.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.springframework.util.Assert;

public class SelectTreeUtils {
	@SuppressWarnings("rawtypes")
	public static List webTree(List<? extends SelectTree> list) {
		Assert.notNull(list);
		Generator gen = new Generator(list);
		return gen.generate();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List handleTreeChild(List<? extends SelectTree> list) {
		Assert.notNull(list);
		List<SelectTree> roots = new ArrayList<SelectTree>();
		SelectTree p;
		Set child;
		for (SelectTree n : list) {
			p = n.getTreeParent();
			if (p == null || p.getId() == null || !list.contains(p)) {
				roots.add(n);
			} else {
				child = p.getTreeChildRaw();
				if (child == null) {
					child = new LinkedHashSet<SelectTree>();
					p.setTreeChild(child);
				}
				child.add(n);
			}
		}
		return roots;
	}

	private static class Generator {
		private List<? extends SelectTree> roots;

		public Generator(List<? extends SelectTree> roots) {
			this.roots = roots;
		}

		/**
		 * �����
		 *
		 * @return
		 */
		public List<? extends SelectTree> generate() {
			List<SelectTree> container = new ArrayList<SelectTree>();
			Stack<Boolean> isEndList = new Stack<Boolean>();
			isEndList.add(new Boolean(true));
			for (SelectTree o : roots) {
				container = node(container, o, 0, isEndList);
			}
			return container;
		}

		private List<SelectTree> node(List<SelectTree> container,
				SelectTree node, int deep, Stack<Boolean> isEndList) {
			if (container == null) {
				container = new ArrayList<SelectTree>();
			}
			StringBuilder sb = new StringBuilder();
			// �ո���
			if (deep >= 1) {
				sb.append("&nbsp;");
			}
			// ������
			for (int i = 1; i < deep; i++) {
				if (!isEndList.get(i)) {
					sb.append("��");
				} else {
					sb.append("��");
				}
			}
			// �ڵ���
			if (deep == 0) {
				// ���ڵ�
				sb.append("��");
			} else if (isEndList.get(deep)) {
				sb.append("��");
			} else {
				sb.append("��");
			}
			sb.append(node.getTreeName());
			node.setSelectTree(sb.toString());
			container.add(node);
			// �ӽڵ�
			Set<? extends SelectTree> cld = node.getTreeChild();
			if (cld != null) {
				for (Iterator<? extends SelectTree> it = cld.iterator(); it
						.hasNext();) {
					SelectTree o = it.next();
					// ��ջ
					isEndList.push(!it.hasNext());
					node(container, o, deep + 1, isEndList);
					// ��ջ
					isEndList.pop();
				}
			}
			return container;
		}
	}
}
