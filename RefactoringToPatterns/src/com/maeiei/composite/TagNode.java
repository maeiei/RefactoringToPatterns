package com.maeiei.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {

	private String name = "";

	private String value = "";

	private StringBuffer attributes;

	private List<TagNode> children;

	private TagNode parent;

	public TagNode(String name) {
		this.name = name;

		this.attributes = new StringBuffer();
	}

	public void addAttributes(String attribute, String value) {

		this.attributes.append(" ");
		this.attributes.append(attribute);
		this.attributes.append("='");
		this.attributes.append(value);
		this.attributes.append("'");
	}

	public void addValue(String value) {
		this.value = value;
	}

	public String toString() {

		StringBuffer result = new StringBuffer();

		appendContentsTo(result);

		return result.toString();

	}

	public String appendContentsTo(StringBuffer result) {

		writeOpenTagTo(result);

		writeChildrenTo(result);

		writeValueTo(result);

		writeEndTagTo(result);

		return result.toString();
	}

	private void writeValueTo(StringBuffer result) {
		if (!value.equals("")) {
			result.append(value);
		}
	}

	private void writeEndTagTo(StringBuffer result) {
		result.append("</");
		result.append(name);
		result.append(">");
	}

	private void writeOpenTagTo(StringBuffer result) {

		result.append("<");
		result.append(name);
		result.append(attributes);
		result.append(">");
	}

	private void writeChildrenTo(StringBuffer result) {
		Iterator<TagNode> iterator = getChildren().iterator();
		while (iterator.hasNext()) {
			TagNode node = iterator.next();
			node.appendContentsTo(result);
		}
	}

	public void add(TagNode childNode) {

		childNode.setParent(this);

		this.getChildren().add(childNode);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public StringBuffer getAttributes() {
		return attributes;
	}

	public void setAttributes(StringBuffer attributes) {
		this.attributes = attributes;
	}

	public List<TagNode> getChildren() {
		if (children == null) {
			this.children = new ArrayList<>();
		}
		return children;
	}

	public void setChildren(List<TagNode> children) {
		if (children == null) {
			this.children = new ArrayList<TagNode>();
		} else {
			this.children = children;
		}
	}

	public TagNode getParent() {
		return parent;
	}

	public void setParent(TagNode parent) {
		this.parent = parent;
	}
}
