package org.openlca.xmile.model2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Header {

	// region fields

	@XmlElement
	private String vendor;

	@XmlElement
	private String name;

	@XmlElement
	private String version;

	@XmlElement
	private String caption;

	@XmlElement
	private String author;

	@XmlElement
	private String affiliation;

	@XmlElement
	private String client;

	@XmlElement
	private String copyright;

	@XmlElement
	private String created;

	@XmlElement
	private String modified;

	@XmlElement
	private String uuid;

	// endregion

	// region getters

	public String vendor() {
		return vendor;
	}

	public String name() {
		return name;
	}

	public String version() {
		return version;
	}

	public String caption() {
		return caption;
	}

	public String author() {
		return author;
	}

	public String affiliation() {
		return affiliation;
	}

	public String client() {
		return client;
	}

	public String copyright() {
		return copyright;
	}

	public String created() {
		return created;
	}

	public String modified() {
		return modified;
	}

	public String uuid() {
		return uuid;
	}

	// endregion

	// region setters

	public Header withVendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	public Header withName(String name) {
		this.name = name;
		return this;
	}

	public Header withVersion(String version) {
		this.version = version;
		return this;
	}

	public Header withCaption(String caption) {
		this.caption = caption;
		return this;
	}

	public Header withAuthor(String author) {
		this.author = author;
		return this;
	}

	public Header withAffiliation(String affiliation) {
		this.affiliation = affiliation;
		return this;
	}

	public Header withClient(String client) {
		this.client = client;
		return this;
	}

	public Header withCopyright(String copyright) {
		this.copyright = copyright;
		return this;
	}

	public Header withCreated(String created) {
		this.created = created;
		return this;
	}

	public Header withModified(String modified) {
		this.modified = modified;
		return this;
	}

	public Header withUUID(String uuid) {
		this.uuid = uuid;
		return this;
	}

	// endregion

}
