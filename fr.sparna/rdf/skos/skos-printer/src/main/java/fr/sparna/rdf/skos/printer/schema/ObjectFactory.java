//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.07 at 09:51:49 AM CEST 
//


package fr.sparna.rdf.skos.printer.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.sparna.rdf.skos.printer.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _KwicIndex_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "kwicIndex");
    private final static QName _KosDocument_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "kosDocument");
    private final static QName _Node_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "node");
    private final static QName _Str_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "str");
    private final static QName _Tree_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "tree");
    private final static QName _KosDisplay_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "kosDisplay");
    private final static QName _Att_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "att");
    private final static QName _List_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "list");
    private final static QName _Label_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "label");
    private final static QName _Table_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "table");
    private final static QName _Header_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "header");
    private final static QName _Section_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "section");
    private final static QName _ConceptBlock_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "conceptBlock");
    private final static QName _Body_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "body");
    private final static QName _NodeData_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "nodeData");
    private final static QName _Link_QNAME = new QName("http://www.sparna.fr/thesaurus-display", "link");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.sparna.rdf.skos.printer.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tree }
     * 
     */
    public Tree createTree() {
        return new Tree();
    }

    /**
     * Create an instance of {@link Section }
     * 
     */
    public Section createSection() {
        return new Section();
    }

    /**
     * Create an instance of {@link NodeData }
     * 
     */
    public NodeData createNodeData() {
        return new NodeData();
    }

    /**
     * Create an instance of {@link RowType }
     * 
     */
    public RowType createRowType() {
        return new RowType();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link KosDocument }
     * 
     */
    public KosDocument createKosDocument() {
        return new KosDocument();
    }

    /**
     * Create an instance of {@link KosDocumentBody }
     * 
     */
    public KosDocumentBody createKosDocumentBody() {
        return new KosDocumentBody();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link KwicIndex }
     * 
     */
    public KwicIndex createKwicIndex() {
        return new KwicIndex();
    }

    /**
     * Create an instance of {@link Table }
     * 
     */
    public Table createTable() {
        return new Table();
    }

    /**
     * Create an instance of {@link StyledString }
     * 
     */
    public StyledString createStyledString() {
        return new StyledString();
    }

    /**
     * Create an instance of {@link KwicEntry }
     * 
     */
    public KwicEntry createKwicEntry() {
        return new KwicEntry();
    }

    /**
     * Create an instance of {@link Att }
     * 
     */
    public Att createAtt() {
        return new Att();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link ListItem }
     * 
     */
    public ListItem createListItem() {
        return new ListItem();
    }

    /**
     * Create an instance of {@link Link }
     * 
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link KosDocumentHeader }
     * 
     */
    public KosDocumentHeader createKosDocumentHeader() {
        return new KosDocumentHeader();
    }

    /**
     * Create an instance of {@link CellType }
     * 
     */
    public CellType createCellType() {
        return new CellType();
    }

    /**
     * Create an instance of {@link KosDisplay }
     * 
     */
    public KosDisplay createKosDisplay() {
        return new KosDisplay();
    }

    /**
     * Create an instance of {@link ConceptBlock }
     * 
     */
    public ConceptBlock createConceptBlock() {
        return new ConceptBlock();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KwicIndex }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "kwicIndex")
    public JAXBElement<KwicIndex> createKwicIndex(KwicIndex value) {
        return new JAXBElement<KwicIndex>(_KwicIndex_QNAME, KwicIndex.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KosDocument }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "kosDocument")
    public JAXBElement<KosDocument> createKosDocument(KosDocument value) {
        return new JAXBElement<KosDocument>(_KosDocument_QNAME, KosDocument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Node }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "node")
    public JAXBElement<Node> createNode(Node value) {
        return new JAXBElement<Node>(_Node_QNAME, Node.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StyledString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "str")
    public JAXBElement<StyledString> createStr(StyledString value) {
        return new JAXBElement<StyledString>(_Str_QNAME, StyledString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "tree")
    public JAXBElement<Tree> createTree(Tree value) {
        return new JAXBElement<Tree>(_Tree_QNAME, Tree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KosDisplay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "kosDisplay")
    public JAXBElement<KosDisplay> createKosDisplay(KosDisplay value) {
        return new JAXBElement<KosDisplay>(_KosDisplay_QNAME, KosDisplay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Att }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "att")
    public JAXBElement<Att> createAtt(Att value) {
        return new JAXBElement<Att>(_Att_QNAME, Att.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "list")
    public JAXBElement<List> createList(List value) {
        return new JAXBElement<List>(_List_QNAME, List.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Label }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "label")
    public JAXBElement<Label> createLabel(Label value) {
        return new JAXBElement<Label>(_Label_QNAME, Label.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Table }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "table")
    public JAXBElement<Table> createTable(Table value) {
        return new JAXBElement<Table>(_Table_QNAME, Table.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KosDocumentHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "header")
    public JAXBElement<KosDocumentHeader> createHeader(KosDocumentHeader value) {
        return new JAXBElement<KosDocumentHeader>(_Header_QNAME, KosDocumentHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Section }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "section")
    public JAXBElement<Section> createSection(Section value) {
        return new JAXBElement<Section>(_Section_QNAME, Section.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConceptBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "conceptBlock")
    public JAXBElement<ConceptBlock> createConceptBlock(ConceptBlock value) {
        return new JAXBElement<ConceptBlock>(_ConceptBlock_QNAME, ConceptBlock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KosDocumentBody }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "body")
    public JAXBElement<KosDocumentBody> createBody(KosDocumentBody value) {
        return new JAXBElement<KosDocumentBody>(_Body_QNAME, KosDocumentBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "nodeData")
    public JAXBElement<NodeData> createNodeData(NodeData value) {
        return new JAXBElement<NodeData>(_NodeData_QNAME, NodeData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Link }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sparna.fr/thesaurus-display", name = "link")
    public JAXBElement<Link> createLink(Link value) {
        return new JAXBElement<Link>(_Link_QNAME, Link.class, null, value);
    }

}
