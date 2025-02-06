
package org.openlca.xmile.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "menu_action_choices", namespace = "http://docs.oasis-open.org/xmile/ns/XMILE/v1.0")
@XmlEnum
public enum MenuActionChoices {

    @XmlEnumValue("open")
    OPEN("open"),
    @XmlEnumValue("close")
    CLOSE("close"),
    @XmlEnumValue("save")
    SAVE("save"),
    @XmlEnumValue("save_as")
    SAVE_AS("save_as"),
    @XmlEnumValue("save_as_image")
    SAVE_AS_IMAGE("save_as_image"),
    @XmlEnumValue("revert")
    REVERT("revert"),
    @XmlEnumValue("print_setup")
    PRINT_SETUP("print_setup"),
    @XmlEnumValue("print")
    PRINT("print"),
    @XmlEnumValue("print_screen")
    PRINT_SCREEN("print_screen"),
    @XmlEnumValue("run")
    RUN("run"),
    @XmlEnumValue("pause")
    PAUSE("pause"),
    @XmlEnumValue("resume")
    RESUME("resume"),
    @XmlEnumValue("stop")
    STOP("stop"),
    @XmlEnumValue("run_restore")
    RUN_RESTORE("run_restore"),
    @XmlEnumValue("restore_all")
    RESTORE_ALL("restore_all"),
    @XmlEnumValue("restore_sliders")
    RESTORE_SLIDERS("restore_sliders"),
    @XmlEnumValue("restore_knobs")
    RESTORE_KNOBS("restore_knobs"),
    @XmlEnumValue("restore_list_inputs")
    RESTORE_LIST_INPUTS("restore_list_inputs"),
    @XmlEnumValue("restore_graphical_inputs")
    RESTORE_GRAPHICAL_INPUTS("restore_graphical_inputs"),
    @XmlEnumValue("restore_switches")
    RESTORE_SWITCHES("restore_switches"),
    @XmlEnumValue("restore_numeric_displays")
    RESTORE_NUMERIC_DISPLAYS("restore_numeric_displays"),
    @XmlEnumValue("restore_graphs_tables")
    RESTORE_GRAPHS_TABLES("restore_graphs_tables"),
    @XmlEnumValue("restore_lamps_gauges")
    RESTORE_LAMPS_GAUGES("restore_lamps_gauges"),
    @XmlEnumValue("data_manager")
    DATA_MANAGER("data_manager"),
    @XmlEnumValue("save_data_now")
    SAVE_DATA_NOW("save_data_now"),
    @XmlEnumValue("import_now")
    IMPORT_NOW("import_now"),
    @XmlEnumValue("export_now")
    EXPORT_NOW("export_now"),
    @XmlEnumValue("exit")
    EXIT("exit"),
    @XmlEnumValue("find")
    FIND("find"),
    @XmlEnumValue("run_specs")
    RUN_SPECS("run_specs");
    private final String value;

    MenuActionChoices(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MenuActionChoices fromValue(String v) {
        for (MenuActionChoices c: MenuActionChoices.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
