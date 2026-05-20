module com.example.bidblitz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    requires org.eclipse.persistence.jpa;
    requires org.eclipse.persistence.core;
    requires java.sql;

    opens com.example.bidblitz to javafx.fxml;
    opens com.example.bidblitz.model to org.eclipse.persistence.core, org.eclipse.persistence.jpa;
    opens com.example.bidblitz.service to org.eclipse.persistence.core;
    opens com.example.bidblitz.util to org.eclipse.persistence.core;
    opens com.example.bidblitz.repository to org.eclipse.persistence.core;

    exports com.example.bidblitz;
    exports com.example.bidblitz.auction;
    opens com.example.bidblitz.auction to javafx.fxml;
}