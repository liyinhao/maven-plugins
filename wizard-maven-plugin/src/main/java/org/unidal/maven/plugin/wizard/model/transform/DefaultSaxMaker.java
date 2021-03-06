package org.unidal.maven.plugin.wizard.model.transform;

import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_CAT;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_DEFAULT;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_JSTL;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_LAYOUT;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_MODULE;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_NAME;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_PACKAGE;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_PATH;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_PLUGIN_MANAGEMENT;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_STANDALONE;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_TEMPLATE;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_TITLE;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_VIEW;
import static org.unidal.maven.plugin.wizard.model.Constants.ATTR_WEBRES;

import org.xml.sax.Attributes;

import org.unidal.maven.plugin.wizard.model.entity.Datasource;
import org.unidal.maven.plugin.wizard.model.entity.Group;
import org.unidal.maven.plugin.wizard.model.entity.Jdbc;
import org.unidal.maven.plugin.wizard.model.entity.Model;
import org.unidal.maven.plugin.wizard.model.entity.Module;
import org.unidal.maven.plugin.wizard.model.entity.Page;
import org.unidal.maven.plugin.wizard.model.entity.Table;
import org.unidal.maven.plugin.wizard.model.entity.Webapp;
import org.unidal.maven.plugin.wizard.model.entity.Wizard;

public class DefaultSaxMaker implements IMaker<Attributes> {

   @Override
   public Datasource buildDatasource(Attributes attributes) {
      String name = attributes.getValue(ATTR_NAME);
      Datasource datasource = new Datasource(name);

      return datasource;
   }

   @Override
   public Group buildGroup(Attributes attributes) {
      String name = attributes.getValue(ATTR_NAME);
      String _package = attributes.getValue(ATTR_PACKAGE);
      Group group = new Group(name);

      if (_package != null) {
         group.setPackage(_package);
      }

      return group;
   }

   @Override
   public Jdbc buildJdbc(Attributes attributes) {
      String _package = attributes.getValue(ATTR_PACKAGE);
      String name = attributes.getValue(ATTR_NAME);
      Jdbc jdbc = new Jdbc(name);

      if (_package != null) {
         jdbc.setPackage(_package);
      }

      return jdbc;
   }

   @Override
   public Model buildModel(Attributes attributes) {
      String _package = attributes.getValue(ATTR_PACKAGE);
      String name = attributes.getValue(ATTR_NAME);
      Model model = new Model(name);

      if (_package != null) {
         model.setPackage(_package);
      }

      return model;
   }

   @Override
   public Module buildModule(Attributes attributes) {
      String name = attributes.getValue(ATTR_NAME);
      String path = attributes.getValue(ATTR_PATH);
      String _default = attributes.getValue(ATTR_DEFAULT);
      String _package = attributes.getValue(ATTR_PACKAGE);
      Module module = new Module(name);

      if (path != null) {
         module.setPath(path);
      }

      if (_default != null) {
         module.setDefault(convert(Boolean.class, _default, null));
      }

      if (_package != null) {
         module.setPackage(_package);
      }

      return module;
   }

   @Override
   public Page buildPage(Attributes attributes) {
      String name = attributes.getValue(ATTR_NAME);
      String title = attributes.getValue(ATTR_TITLE);
      String _default = attributes.getValue(ATTR_DEFAULT);
      String _package = attributes.getValue(ATTR_PACKAGE);
      String path = attributes.getValue(ATTR_PATH);
      String view = attributes.getValue(ATTR_VIEW);
      String standalone = attributes.getValue(ATTR_STANDALONE);
      String template = attributes.getValue(ATTR_TEMPLATE);
      Page page = new Page(name);

      if (title != null) {
         page.setTitle(title);
      }

      if (_default != null) {
         page.setDefault(convert(Boolean.class, _default, null));
      }

      if (_package != null) {
         page.setPackage(_package);
      }

      if (path != null) {
         page.setPath(path);
      }

      if (view != null) {
         page.setView(view);
      }

      if (standalone != null) {
         page.setStandalone(convert(Boolean.class, standalone, null));
      }

      if (template != null) {
         page.setTemplate(template);
      }

      return page;
   }

   @Override
   public Table buildTable(Attributes attributes) {
      String name = attributes.getValue(ATTR_NAME);
      Table table = new Table(name);

      return table;
   }

   @Override
   public Webapp buildWebapp(Attributes attributes) {
      String _package = attributes.getValue(ATTR_PACKAGE);
      String name = attributes.getValue(ATTR_NAME);
      String module = attributes.getValue(ATTR_MODULE);
      String webres = attributes.getValue(ATTR_WEBRES);
      String cat = attributes.getValue(ATTR_CAT);
      String pluginManagement = attributes.getValue(ATTR_PLUGIN_MANAGEMENT);
      String jstl = attributes.getValue(ATTR_JSTL);
      String layout = attributes.getValue(ATTR_LAYOUT);
      Webapp webapp = new Webapp();

      if (_package != null) {
         webapp.setPackage(_package);
      }

      if (name != null) {
         webapp.setName(name);
      }

      if (module != null) {
         webapp.setModule(convert(Boolean.class, module, null));
      }

      if (webres != null) {
         webapp.setWebres(convert(Boolean.class, webres, null));
      }

      if (cat != null) {
         webapp.setCat(convert(Boolean.class, cat, null));
      }

      if (pluginManagement != null) {
         webapp.setPluginManagement(convert(Boolean.class, pluginManagement, null));
      }

      if (jstl != null) {
         webapp.setJstl(convert(Boolean.class, jstl, null));
      }

      if (layout != null) {
         webapp.setLayout(layout);
      }

      return webapp;
   }

   @Override
   public Wizard buildWizard(Attributes attributes) {
      String _package = attributes.getValue(ATTR_PACKAGE);
      Wizard wizard = new Wizard();

      if (_package != null) {
         wizard.setPackage(_package);
      }

      return wizard;
   }

   @SuppressWarnings("unchecked")
   protected <T> T convert(Class<T> type, String value, T defaultValue) {
      if (value == null || value.length() == 0) {
         return defaultValue;
      }

      if (type == Boolean.class || type == Boolean.TYPE) {
         return (T) Boolean.valueOf(value);
      } else if (type == Integer.class || type == Integer.TYPE) {
         return (T) Integer.valueOf(value);
      } else if (type == Long.class || type == Long.TYPE) {
         return (T) Long.valueOf(value);
      } else if (type == Short.class || type == Short.TYPE) {
         return (T) Short.valueOf(value);
      } else if (type == Float.class || type == Float.TYPE) {
         return (T) Float.valueOf(value);
      } else if (type == Double.class || type == Double.TYPE) {
         return (T) Double.valueOf(value);
      } else if (type == Byte.class || type == Byte.TYPE) {
         return (T) Byte.valueOf(value);
      } else if (type == Character.class || type == Character.TYPE) {
         return (T) (Character) value.charAt(0);
      } else {
         return (T) value;
      }
   }
}
