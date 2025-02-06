
package org.openlca.xmile.model;


import javax.xml.namespace.QName;

import org.openlca.xmile.model.Module.Connector;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.openlca.xmile.model package.
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

    private final static QName _ContactAddress_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "address");
    private final static QName _ContactPhone_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "phone");
    private final static QName _ContactFax_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "fax");
    private final static QName _ContactEmail_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "email");
    private final static QName _ContactWebsite_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "website");
    private final static QName _StockEqn_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "eqn");
    private final static QName _StockMathml_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "mathml");
    private final static QName _StockUnits_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "units");
    private final static QName _StockDoc_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "doc");
    private final static QName _StockInflow_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "inflow");
    private final static QName _StockOutflow_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "outflow");
    private final static QName _StockQueue_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "queue");
    private final static QName _StockNonNegative_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "non_negative");
    private final static QName _StockElement_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "element");
    private final static QName _FlowMultiplier_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "multiplier");
    private final static QName _FlowOverflow_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "overflow");
    private final static QName _FlowLeak_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "leak");
    private final static QName _FlowLeakIntegers_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "leak_integers");
    private final static QName _MacroParm_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "parm");
    private final static QName _MacroFormat_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "format");
    private final static QName _ViewContentTypeConnectorFromAlias_QNAME = new QName("http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", "alias");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.openlca.xmile.model
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Options }
     *
     */
    public Options createOptions() {
        return new Options();
    }

    /**
     * Create an instance of {@link Includes }
     *
     */
    public Includes createIncludes() {
        return new Includes();
    }

    /**
     * Create an instance of {@link SimSpecs }
     *
     */
    public SimSpecs createSimSpecs() {
        return new SimSpecs();
    }

    /**
     * Create an instance of {@link ModelUnits }
     *
     */
    public ModelUnits createModelUnits() {
        return new ModelUnits();
    }

    /**
     * Create an instance of {@link Behavior }
     *
     */
    public Behavior createBehavior() {
        return new Behavior();
    }

    /**
     * Create an instance of {@link Data }
     *
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Dimensions }
     *
     */
    public Dimensions createDimensions() {
        return new Dimensions();
    }

    /**
     * Create an instance of {@link EventPoster }
     *
     */
    public EventPoster createEventPoster() {
        return new EventPoster();
    }

    /**
     * Create an instance of {@link Stock }
     *
     */
    public Stock createStock() {
        return new Stock();
    }

    /**
     * Create an instance of {@link Flow }
     *
     */
    public Flow createFlow() {
        return new Flow();
    }

    /**
     * Create an instance of {@link Aux }
     *
     */
    public Aux createAux() {
        return new Aux();
    }

    /**
     * Create an instance of {@link Group }
     *
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link Module }
     *
     */
    public Module createModule() {
        return new Module();
    }

    /**
     * Create an instance of {@link Views }
     *
     */
    public Views createViews() {
        return new Views();
    }

    /**
     * Create an instance of {@link Xmile }
     *
     */
    public Xmile createXmile() {
        return new Xmile();
    }

    /**
     * Create an instance of {@link Slider }
     *
     */
    public Slider createSlider() {
        return new Slider();
    }

    /**
     * Create an instance of {@link Knob }
     *
     */
    public Knob createKnob() {
        return new Knob();
    }

    /**
     * Create an instance of {@link ListInput }
     *
     */
    public ListInput createListInput() {
        return new ListInput();
    }

    /**
     * Create an instance of {@link NumericDisplay }
     *
     */
    public NumericDisplay createNumericDisplay() {
        return new NumericDisplay();
    }

    /**
     * Create an instance of {@link Switch }
     *
     */
    public Switch createSwitch() {
        return new Switch();
    }

    /**
     * Create an instance of {@link GraphicalInput }
     *
     */
    public GraphicalInput createGraphicalInput() {
        return new GraphicalInput();
    }

    /**
     * Create an instance of {@link ViewContentType }
     *
     */
    public ViewContentType createViewContentType() {
        return new ViewContentType();
    }

    /**
     * Create an instance of {@link Plot }
     *
     */
    public Plot createPlot() {
        return new Plot();
    }

    /**
     * Create an instance of {@link SwitchAction }
     *
     */
    public SwitchAction createSwitchAction() {
        return new SwitchAction();
    }

    /**
     * Create an instance of {@link ViewContentType.Button }
     *
     */
    public ViewContentType.Button createViewContentTypeButton() {
        return new ViewContentType.Button();
    }

    /**
     * Create an instance of {@link ViewContentType.Table }
     *
     */
    public ViewContentType.Table createViewContentTypeTable() {
        return new ViewContentType.Table();
    }

    /**
     * Create an instance of {@link ViewContentType.Table.Item }
     *
     */
    public ViewContentType.Table.Item createViewContentTypeTableItem() {
        return new ViewContentType.Table.Item();
    }

    /**
     * Create an instance of {@link ViewContentType.Connector }
     *
     */
    public ViewContentType.Connector createViewContentTypeConnector() {
        return new ViewContentType.Connector();
    }

    /**
     * Create an instance of {@link ViewContentType.Connector.From }
     *
     */
    public ViewContentType.Connector.From createViewContentTypeConnectorFrom() {
        return new ViewContentType.Connector.From();
    }

    /**
     * Create an instance of {@link ViewContentType.Group }
     *
     */
    public ViewContentType.Group createViewContentTypeGroup() {
        return new ViewContentType.Group();
    }

    /**
     * Create an instance of {@link ViewContentType.Flow }
     *
     */
    public ViewContentType.Flow createViewContentTypeFlow() {
        return new ViewContentType.Flow();
    }

    /**
     * Create an instance of {@link ViewContentType.Flow.Pts }
     *
     */
    public ViewContentType.Flow.Pts createViewContentTypeFlowPts() {
        return new ViewContentType.Flow.Pts();
    }

    /**
     * Create an instance of {@link ListInput.NumericInput }
     *
     */
    public ListInput.NumericInput createListInputNumericInput() {
        return new ListInput.NumericInput();
    }

    /**
     * Create an instance of {@link Xmile.Dimensions }
     *
     */
    public Xmile.Dimensions createXmileDimensions() {
        return new Xmile.Dimensions();
    }

    /**
     * Create an instance of {@link Xmile.Dimensions.Dim }
     *
     */
    public Xmile.Dimensions.Dim createXmileDimensionsDim() {
        return new Xmile.Dimensions.Dim();
    }

    /**
     * Create an instance of {@link EventPoster.Threshold }
     *
     */
    public EventPoster.Threshold createEventPosterThreshold() {
        return new EventPoster.Threshold();
    }

    /**
     * Create an instance of {@link Data.Export }
     *
     */
    public Data.Export createDataExport() {
        return new Data.Export();
    }

    /**
     * Create an instance of {@link Header }
     *
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link Image }
     *
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link Options.UsesConveyor }
     *
     */
    public Options.UsesConveyor createOptionsUsesConveyor() {
        return new Options.UsesConveyor();
    }

    /**
     * Create an instance of {@link Options.UsesQueue }
     *
     */
    public Options.UsesQueue createOptionsUsesQueue() {
        return new Options.UsesQueue();
    }

    /**
     * Create an instance of {@link EmptyType }
     *
     */
    public EmptyType createEmptyType() {
        return new EmptyType();
    }

    /**
     * Create an instance of {@link Options.UsesMacros }
     *
     */
    public Options.UsesMacros createOptionsUsesMacros() {
        return new Options.UsesMacros();
    }

    /**
     * Create an instance of {@link Options.UsesEventPosters }
     *
     */
    public Options.UsesEventPosters createOptionsUsesEventPosters() {
        return new Options.UsesEventPosters();
    }

    /**
     * Create an instance of {@link Options.UsesOutputs }
     *
     */
    public Options.UsesOutputs createOptionsUsesOutputs() {
        return new Options.UsesOutputs();
    }

    /**
     * Create an instance of {@link Options.UsesInputs }
     *
     */
    public Options.UsesInputs createOptionsUsesInputs() {
        return new Options.UsesInputs();
    }

    /**
     * Create an instance of {@link Options.UsesArrays }
     *
     */
    public Options.UsesArrays createOptionsUsesArrays() {
        return new Options.UsesArrays();
    }

    /**
     * Create an instance of {@link Product }
     *
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Contact }
     *
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link Includes.Include }
     *
     */
    public Includes.Include createIncludesInclude() {
        return new Includes.Include();
    }

    /**
     * Create an instance of {@link SimSpecs.Dt }
     *
     */
    public SimSpecs.Dt createSimSpecsDt() {
        return new SimSpecs.Dt();
    }

    /**
     * Create an instance of {@link SimSpecs.Run }
     *
     */
    public SimSpecs.Run createSimSpecsRun() {
        return new SimSpecs.Run();
    }

    /**
     * Create an instance of {@link ModelUnits.Unit }
     *
     */
    public ModelUnits.Unit createModelUnitsUnit() {
        return new ModelUnits.Unit();
    }

    /**
     * Create an instance of {@link BooleanOrEmptyType }
     *
     */
    public BooleanOrEmptyType createBooleanOrEmptyType() {
        return new BooleanOrEmptyType();
    }

    /**
     * Create an instance of {@link Behavior.Stock }
     *
     */
    public Behavior.Stock createBehaviorStock() {
        return new Behavior.Stock();
    }

    /**
     * Create an instance of {@link Behavior.Flow }
     *
     */
    public Behavior.Flow createBehaviorFlow() {
        return new Behavior.Flow();
    }

    /**
     * Create an instance of {@link Data.Import }
     *
     */
    public Data.Import createDataImport() {
        return new Data.Import();
    }

    /**
     * Create an instance of {@link Style }
     *
     */
    public Style createStyle() {
        return new Style();
    }

    /**
     * Create an instance of {@link StyleType }
     *
     */
    public StyleType createStyleType() {
        return new StyleType();
    }

    /**
     * Create an instance of {@link Macro }
     *
     */
    public Macro createMacro() {
        return new Macro();
    }

    /**
     * Create an instance of {@link Variables }
     *
     */
    public Variables createVariables() {
        return new Variables();
    }

    /**
     * Create an instance of {@link Gf }
     *
     */
    public Gf createGf() {
        return new Gf();
    }

    public Equation createEquation() {
        return new Equation();
    }

    /**
     * Create an instance of {@link MinMaxType }
     *
     */
    public MinMaxType createMinMaxType() {
        return new MinMaxType();
    }

    /**
     * Create an instance of {@link PointsType }
     *
     */
    public PointsType createPointsType() {
        return new PointsType();
    }

    /**
     * Create an instance of {@link Dimensions.Dim }
     *
     */
    public Dimensions.Dim createDimensionsDim() {
        return new Dimensions.Dim();
    }

    /**
     * Create an instance of {@link Scale }
     *
     */
    public Scale createScale() {
        return new Scale();
    }

    /**
     * Create an instance of {@link Range }
     *
     */
    public Range createRange() {
        return new Range();
    }

    /**
     * Create an instance of {@link Format }
     *
     */
    public Format createFormat() {
        return new Format();
    }

    /**
     * Create an instance of {@link Conveyor }
     *
     */
    public Conveyor createConveyor() {
        return new Conveyor();
    }

    /**
     * Create an instance of {@link Stock.Element }
     *
     */
    public Stock.Element createStockElement() {
        return new Stock.Element();
    }

    /**
     * Create an instance of {@link Flow.Element }
     *
     */
    public Flow.Element createFlowElement() {
        return new Flow.Element();
    }

    /**
     * Create an instance of {@link Aux.Element }
     *
     */
    public Aux.Element createAuxElement() {
        return new Aux.Element();
    }

    /**
     * Create an instance of {@link Group.Entity }
     *
     */
    public Group.Entity createGroupEntity() {
        return new Group.Entity();
    }

    /**
     * Create an instance of {@link Connector }
     *
     */
    public Connector createModuleConnect() {
        return new Connector();
    }

    /**
     * Create an instance of {@link Views.View }
     *
     */
    public Views.View createViewsView() {
        return new Views.View();
    }

    /**
     * Create an instance of {@link Model }
     *
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link Entity }
     *
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link Slider.Entity }
     *
     */
    public Slider.Entity createSliderEntity() {
        return new Slider.Entity();
    }

    /**
     * Create an instance of {@link ResetTo }
     *
     */
    public ResetTo createResetTo() {
        return new ResetTo();
    }

    /**
     * Create an instance of {@link Knob.Entity }
     *
     */
    public Knob.Entity createKnobEntity() {
        return new Knob.Entity();
    }

    /**
     * Create an instance of {@link NumericDisplay.Entity }
     *
     */
    public NumericDisplay.Entity createNumericDisplayEntity() {
        return new NumericDisplay.Entity();
    }

    /**
     * Create an instance of {@link Switch.Entity }
     *
     */
    public Switch.Entity createSwitchEntity() {
        return new Switch.Entity();
    }

    /**
     * Create an instance of {@link GraphicalInput.Entity }
     *
     */
    public GraphicalInput.Entity createGraphicalInputEntity() {
        return new GraphicalInput.Entity();
    }

    /**
     * Create an instance of {@link StackedContainer }
     *
     */
    public StackedContainer createStackedContainer() {
        return new StackedContainer();
    }

    /**
     * Create an instance of {@link ViewContentType.Stock }
     *
     */
    public ViewContentType.Stock createViewContentTypeStock() {
        return new ViewContentType.Stock();
    }

    /**
     * Create an instance of {@link ViewContentType.Aux }
     *
     */
    public ViewContentType.Aux createViewContentTypeAux() {
        return new ViewContentType.Aux();
    }

    /**
     * Create an instance of {@link ViewContentType.Module }
     *
     */
    public ViewContentType.Module createViewContentTypeModule() {
        return new ViewContentType.Module();
    }

    /**
     * Create an instance of {@link ViewContentType.Alias }
     *
     */
    public ViewContentType.Alias createViewContentTypeAlias() {
        return new ViewContentType.Alias();
    }

    /**
     * Create an instance of {@link TextBox }
     *
     */
    public TextBox createTextBox() {
        return new TextBox();
    }

    /**
     * Create an instance of {@link GraphicsFrame }
     *
     */
    public GraphicsFrame createGraphicsFrame() {
        return new GraphicsFrame();
    }

    /**
     * Create an instance of {@link Video }
     *
     */
    public Video createVideo() {
        return new Video();
    }

    /**
     * Create an instance of {@link ViewContentType.Graph }
     *
     */
    public ViewContentType.Graph createViewContentTypeGraph() {
        return new ViewContentType.Graph();
    }

    /**
     * Create an instance of {@link ViewContentType.Options }
     *
     */
    public ViewContentType.Options createViewContentTypeOptions() {
        return new ViewContentType.Options();
    }

    /**
     * Create an instance of {@link Plot.Entity }
     *
     */
    public Plot.Entity createPlotEntity() {
        return new Plot.Entity();
    }

    /**
     * Create an instance of {@link SwitchAction.Group }
     *
     */
    public SwitchAction.Group createSwitchActionGroup() {
        return new SwitchAction.Group();
    }

    /**
     * Create an instance of {@link Popup }
     *
     */
    public Popup createPopup() {
        return new Popup();
    }

    /**
     * Create an instance of {@link Sound }
     *
     */
    public Sound createSound() {
        return new Sound();
    }

    /**
     * Create an instance of {@link Link }
     *
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link Shape }
     *
     */
    public Shape createShape() {
        return new Shape();
    }

    /**
     * Create an instance of {@link ViewContentType.Button.MenuAction }
     *
     */
    public ViewContentType.Button.MenuAction createViewContentTypeButtonMenuAction() {
        return new ViewContentType.Button.MenuAction();
    }

    /**
     * Create an instance of {@link ViewContentType.Table.Item.Entity }
     *
     */
    public ViewContentType.Table.Item.Entity createViewContentTypeTableItemEntity() {
        return new ViewContentType.Table.Item.Entity();
    }

    /**
     * Create an instance of {@link ViewContentType.Connector.From.Alias }
     *
     */
    public ViewContentType.Connector.From.Alias createViewContentTypeConnectorFromAlias() {
        return new ViewContentType.Connector.From.Alias();
    }

    /**
     * Create an instance of {@link ViewContentType.Group.Item }
     *
     */
    public ViewContentType.Group.Item createViewContentTypeGroupItem() {
        return new ViewContentType.Group.Item();
    }

    /**
     * Create an instance of {@link ViewContentType.Flow.Pts.Pt }
     *
     */
    public ViewContentType.Flow.Pts.Pt createViewContentTypeFlowPtsPt() {
        return new ViewContentType.Flow.Pts.Pt();
    }

    /**
     * Create an instance of {@link ListInput.NumericInput.Entity }
     *
     */
    public ListInput.NumericInput.Entity createListInputNumericInputEntity() {
        return new ListInput.NumericInput.Entity();
    }

    /**
     * Create an instance of {@link Xmile.Dimensions.Dim.Elem }
     *
     */
    public Xmile.Dimensions.Dim.Elem createXmileDimensionsDimElem() {
        return new Xmile.Dimensions.Dim.Elem();
    }

    /**
     * Create an instance of {@link EventPoster.Threshold.Event }
     *
     */
    public EventPoster.Threshold.Event createEventPosterThresholdEvent() {
        return new EventPoster.Threshold.Event();
    }

    /**
     * Create an instance of {@link Data.Export.Table }
     *
     */
    public Data.Export.Table createDataExportTable() {
        return new Data.Export.Table();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "address", scope = Contact.class)
    public JAXBElement<String> createContactAddress(String value) {
        return new JAXBElement<String>(_ContactAddress_QNAME, String.class, Contact.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "phone", scope = Contact.class)
    public JAXBElement<String> createContactPhone(String value) {
        return new JAXBElement<String>(_ContactPhone_QNAME, String.class, Contact.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "fax", scope = Contact.class)
    public JAXBElement<String> createContactFax(String value) {
        return new JAXBElement<String>(_ContactFax_QNAME, String.class, Contact.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "email", scope = Contact.class)
    public JAXBElement<String> createContactEmail(String value) {
        return new JAXBElement<String>(_ContactEmail_QNAME, String.class, Contact.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "website", scope = Contact.class)
    public JAXBElement<String> createContactWebsite(String value) {
        return new JAXBElement<String>(_ContactWebsite_QNAME, String.class, Contact.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Stock.class)
    public JAXBElement<String> createStockEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "mathml", scope = Stock.class)
    public JAXBElement<String> createStockMathml(String value) {
        return new JAXBElement<String>(_StockMathml_QNAME, String.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "units", scope = Stock.class)
    public JAXBElement<String> createStockUnits(String value) {
        return new JAXBElement<String>(_StockUnits_QNAME, String.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "doc", scope = Stock.class)
    public JAXBElement<String> createStockDoc(String value) {
        return new JAXBElement<String>(_StockDoc_QNAME, String.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "inflow", scope = Stock.class)
    public JAXBElement<String> createStockInflow(String value) {
        return new JAXBElement<String>(_StockInflow_QNAME, String.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "outflow", scope = Stock.class)
    public JAXBElement<String> createStockOutflow(String value) {
        return new JAXBElement<String>(_StockOutflow_QNAME, String.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "queue", scope = Stock.class)
    public JAXBElement<EmptyType> createStockQueue(EmptyType value) {
        return new JAXBElement<EmptyType>(_StockQueue_QNAME, EmptyType.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "non_negative", scope = Stock.class)
    public JAXBElement<BooleanOrEmptyType> createStockNonNegative(BooleanOrEmptyType value) {
        return new JAXBElement<BooleanOrEmptyType>(_StockNonNegative_QNAME, BooleanOrEmptyType.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stock.Element }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Stock.Element }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "element", scope = Stock.class)
    public JAXBElement<Stock.Element> createStockElement(Stock.Element value) {
        return new JAXBElement<Stock.Element>(_StockElement_QNAME, Stock.Element.class, Stock.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Flow.class)
    public JAXBElement<String> createFlowEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "mathml", scope = Flow.class)
    public JAXBElement<String> createFlowMathml(String value) {
        return new JAXBElement<String>(_StockMathml_QNAME, String.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "units", scope = Flow.class)
    public JAXBElement<String> createFlowUnits(String value) {
        return new JAXBElement<String>(_StockUnits_QNAME, String.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "doc", scope = Flow.class)
    public JAXBElement<String> createFlowDoc(String value) {
        return new JAXBElement<String>(_StockDoc_QNAME, String.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "multiplier", scope = Flow.class)
    public JAXBElement<String> createFlowMultiplier(String value) {
        return new JAXBElement<String>(_FlowMultiplier_QNAME, String.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "non_negative", scope = Flow.class)
    public JAXBElement<BooleanOrEmptyType> createFlowNonNegative(BooleanOrEmptyType value) {
        return new JAXBElement<BooleanOrEmptyType>(_StockNonNegative_QNAME, BooleanOrEmptyType.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "overflow", scope = Flow.class)
    public JAXBElement<EmptyType> createFlowOverflow(EmptyType value) {
        return new JAXBElement<EmptyType>(_FlowOverflow_QNAME, EmptyType.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "leak", scope = Flow.class)
    public JAXBElement<EmptyType> createFlowLeak(EmptyType value) {
        return new JAXBElement<EmptyType>(_FlowLeak_QNAME, EmptyType.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "leak_integers", scope = Flow.class)
    public JAXBElement<EmptyType> createFlowLeakIntegers(EmptyType value) {
        return new JAXBElement<EmptyType>(_FlowLeakIntegers_QNAME, EmptyType.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flow.Element }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Flow.Element }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "element", scope = Flow.class)
    public JAXBElement<Flow.Element> createFlowElement(Flow.Element value) {
        return new JAXBElement<Flow.Element>(_StockElement_QNAME, Flow.Element.class, Flow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Aux.class)
    public JAXBElement<String> createAuxEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Aux.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "mathml", scope = Aux.class)
    public JAXBElement<String> createAuxMathml(String value) {
        return new JAXBElement<String>(_StockMathml_QNAME, String.class, Aux.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "units", scope = Aux.class)
    public JAXBElement<String> createAuxUnits(String value) {
        return new JAXBElement<String>(_StockUnits_QNAME, String.class, Aux.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "doc", scope = Aux.class)
    public JAXBElement<String> createAuxDoc(String value) {
        return new JAXBElement<String>(_StockDoc_QNAME, String.class, Aux.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aux.Element }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Aux.Element }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "element", scope = Aux.class)
    public JAXBElement<Aux.Element> createAuxElement(Aux.Element value) {
        return new JAXBElement<Aux.Element>(_StockElement_QNAME, Aux.Element.class, Aux.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "parm", scope = Macro.class)
    public JAXBElement<String> createMacroParm(String value) {
        return new JAXBElement<String>(_MacroParm_QNAME, String.class, Macro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Macro.class)
    public JAXBElement<String> createMacroEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Macro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "format", scope = Macro.class)
    public JAXBElement<String> createMacroFormat(String value) {
        return new JAXBElement<String>(_MacroFormat_QNAME, String.class, Macro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "doc", scope = Macro.class)
    public JAXBElement<String> createMacroDoc(String value) {
        return new JAXBElement<String>(_StockDoc_QNAME, String.class, Macro.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewContentType.Connector.From.Alias }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViewContentType.Connector.From.Alias }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "alias", scope = ViewContentType.Connector.From.class)
    public JAXBElement<ViewContentType.Connector.From.Alias> createViewContentTypeConnectorFromAlias(ViewContentType.Connector.From.Alias value) {
        return new JAXBElement<ViewContentType.Connector.From.Alias>(_ViewContentTypeConnectorFromAlias_QNAME, ViewContentType.Connector.From.Alias.class, ViewContentType.Connector.From.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Aux.Element.class)
    public JAXBElement<String> createAuxElementEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Aux.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "mathml", scope = Aux.Element.class)
    public JAXBElement<String> createAuxElementMathml(String value) {
        return new JAXBElement<String>(_StockMathml_QNAME, String.class, Aux.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Flow.Element.class)
    public JAXBElement<String> createFlowElementEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "mathml", scope = Flow.Element.class)
    public JAXBElement<String> createFlowElementMathml(String value) {
        return new JAXBElement<String>(_StockMathml_QNAME, String.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "multiplier", scope = Flow.Element.class)
    public JAXBElement<String> createFlowElementMultiplier(String value) {
        return new JAXBElement<String>(_FlowMultiplier_QNAME, String.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "non_negative", scope = Flow.Element.class)
    public JAXBElement<BooleanOrEmptyType> createFlowElementNonNegative(BooleanOrEmptyType value) {
        return new JAXBElement<BooleanOrEmptyType>(_StockNonNegative_QNAME, BooleanOrEmptyType.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "overflow", scope = Flow.Element.class)
    public JAXBElement<EmptyType> createFlowElementOverflow(EmptyType value) {
        return new JAXBElement<EmptyType>(_FlowOverflow_QNAME, EmptyType.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "leak", scope = Flow.Element.class)
    public JAXBElement<EmptyType> createFlowElementLeak(EmptyType value) {
        return new JAXBElement<EmptyType>(_FlowLeak_QNAME, EmptyType.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "leak_integers", scope = Flow.Element.class)
    public JAXBElement<EmptyType> createFlowElementLeakIntegers(EmptyType value) {
        return new JAXBElement<EmptyType>(_FlowLeakIntegers_QNAME, EmptyType.class, Flow.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "eqn", scope = Stock.Element.class)
    public JAXBElement<String> createStockElementEqn(String value) {
        return new JAXBElement<String>(_StockEqn_QNAME, String.class, Stock.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "mathml", scope = Stock.Element.class)
    public JAXBElement<String> createStockElementMathml(String value) {
        return new JAXBElement<String>(_StockMathml_QNAME, String.class, Stock.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "inflow", scope = Stock.Element.class)
    public JAXBElement<String> createStockElementInflow(String value) {
        return new JAXBElement<String>(_StockInflow_QNAME, String.class, Stock.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "outflow", scope = Stock.Element.class)
    public JAXBElement<String> createStockElementOutflow(String value) {
        return new JAXBElement<String>(_StockOutflow_QNAME, String.class, Stock.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "queue", scope = Stock.Element.class)
    public JAXBElement<EmptyType> createStockElementQueue(EmptyType value) {
        return new JAXBElement<EmptyType>(_StockQueue_QNAME, EmptyType.class, Stock.Element.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BooleanOrEmptyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0", name = "non_negative", scope = Stock.Element.class)
    public JAXBElement<BooleanOrEmptyType> createStockElementNonNegative(BooleanOrEmptyType value) {
        return new JAXBElement<BooleanOrEmptyType>(_StockNonNegative_QNAME, BooleanOrEmptyType.class, Stock.Element.class, value);
    }

}
