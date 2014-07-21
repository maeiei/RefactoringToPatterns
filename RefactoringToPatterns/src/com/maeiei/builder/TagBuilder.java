package com.maeiei.builder;

import com.maeiei.composite.TagNode;

public class TagBuilder {

	private TagNode rootNode;
	private TagNode currentNode;

	private int outputBufferSize;
	private static int TAG_CHARS_SIZE = 5;
	private static int ATTRIBUTE_CHARS_SIZE = 4;

	public TagBuilder(String rootTagName) {

		this.rootNode = new TagNode(rootTagName);
		currentNode = rootNode;
		incrementBufferSizeByTagLenth(rootTagName);
	}

	public void addChild(String childTagName) {

		addTo(currentNode, childTagName);
	}

	public void addSibling(String childTagName) {

		addTo(currentNode.getParent(), childTagName);
	}

	private void addTo(TagNode parentNode, String childTag) {
		
		currentNode = new TagNode(childTag);
		parentNode.add(currentNode);
		
		incrementBufferSizeByTagLenth(childTag);
	}

	public void addToParent(String parentTag, String childTag) {

		TagNode parentNode = findParentNode(parentTag);

		if (parentNode == null) {
			throw new RuntimeException("miss parent tag: " + parentTag);
		}

		addTo(parentNode, childTag);
	}

	private TagNode findParentNode(String parentTag) {

		TagNode parentNode = currentNode;

		while (parentNode != null) {
			if (parentTag.equals(parentNode.getName())) {
				return parentNode;
			} else {
				parentNode = parentNode.getParent();
			}
		}
		return null;
	}

	public String toXml() {
		StringBuffer xmlResult = new StringBuffer(outputBufferSize);
		
		rootNode.appendContentsTo(xmlResult);
		
		return xmlResult.toString();
	}

	public void addAttributes(String attribute, String value) {
		currentNode.addAttributes(attribute, value);
		incrementBufferSizeByAttributeLenth(attribute, value);
	}
	public int bufferSize(){
		return outputBufferSize;
		
	}

	public void addValue(String value) {
		currentNode.setValue(value);
		incrementBufferSizeByValueLenth(value);
	}

	private void incrementBufferSizeByAttributeLenth(String attribute,
			String value) {
		outputBufferSize += (attribute.length() + value.length() + ATTRIBUTE_CHARS_SIZE);
	}

	private void incrementBufferSizeByTagLenth(String tag) {
		outputBufferSize += (tag.length() * 2 + TAG_CHARS_SIZE);
	}

	private void incrementBufferSizeByValueLenth(String value) {
		outputBufferSize += value.length();
	}
}
