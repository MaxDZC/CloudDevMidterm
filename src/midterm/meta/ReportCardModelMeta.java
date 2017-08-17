package midterm.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-08-17 09:09:29")
/** */
public final class ReportCardModelMeta extends org.slim3.datastore.ModelMeta<midterm.model.ReportCardModel> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Integer> gradeLevel = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Integer>(this, "gradeLevel", "gradeLevel", int.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<midterm.model.ReportCardModel, java.util.List<java.lang.Integer>, java.lang.Integer> gradingList = new org.slim3.datastore.CollectionAttributeMeta<midterm.model.ReportCardModel, java.util.List<java.lang.Integer>, java.lang.Integer>(this, "gradingList", "gradingList", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Integer> gradingPeriod = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Integer>(this, "gradingPeriod", "gradingPeriod", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Boolean> passed = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Boolean>(this, "passed", "passed", boolean.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<midterm.model.ReportCardModel> sectionName = new org.slim3.datastore.StringAttributeMeta<midterm.model.ReportCardModel>(this, "sectionName", "sectionName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<midterm.model.ReportCardModel> studentName = new org.slim3.datastore.StringAttributeMeta<midterm.model.ReportCardModel>(this, "studentName", "studentName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Double> totalGrade = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Double>(this, "totalGrade", "totalGrade", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<midterm.model.ReportCardModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ReportCardModelMeta slim3_singleton = new ReportCardModelMeta();

    /**
     * @return the singleton
     */
    public static ReportCardModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public ReportCardModelMeta() {
        super("ReportCardModel", midterm.model.ReportCardModel.class);
    }

    @Override
    public midterm.model.ReportCardModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        midterm.model.ReportCardModel model = new midterm.model.ReportCardModel();
        model.setGradeLevel(longToPrimitiveInt((java.lang.Long) entity.getProperty("gradeLevel")));
        model.setGradingList(longListToIntegerList(entity.getProperty("gradingList")));
        model.setGradingPeriod(longToPrimitiveInt((java.lang.Long) entity.getProperty("gradingPeriod")));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setPassed(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("passed")));
        model.setSectionName((java.lang.String) entity.getProperty("sectionName"));
        model.setStudentName((java.lang.String) entity.getProperty("studentName"));
        model.setTotalGrade((java.lang.Double) entity.getProperty("totalGrade"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        midterm.model.ReportCardModel m = (midterm.model.ReportCardModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("gradeLevel", m.getGradeLevel());
        entity.setProperty("gradingList", m.getGradingList());
        entity.setProperty("gradingPeriod", m.getGradingPeriod());
        entity.setProperty("id", m.getId());
        entity.setProperty("passed", m.isPassed());
        entity.setProperty("sectionName", m.getSectionName());
        entity.setProperty("studentName", m.getStudentName());
        entity.setProperty("totalGrade", m.getTotalGrade());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        midterm.model.ReportCardModel m = (midterm.model.ReportCardModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        midterm.model.ReportCardModel m = (midterm.model.ReportCardModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        midterm.model.ReportCardModel m = (midterm.model.ReportCardModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        midterm.model.ReportCardModel m = (midterm.model.ReportCardModel) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        midterm.model.ReportCardModel m = (midterm.model.ReportCardModel) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("gradeLevel");
        encoder0.encode(writer, m.getGradeLevel());
        if(m.getGradingList() != null){
            writer.setNextPropertyName("gradingList");
            writer.beginArray();
            for(java.lang.Integer v : m.getGradingList()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        writer.setNextPropertyName("gradingPeriod");
        encoder0.encode(writer, m.getGradingPeriod());
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("passed");
        encoder0.encode(writer, m.isPassed());
        if(m.getSectionName() != null){
            writer.setNextPropertyName("sectionName");
            encoder0.encode(writer, m.getSectionName());
        }
        if(m.getStudentName() != null){
            writer.setNextPropertyName("studentName");
            encoder0.encode(writer, m.getStudentName());
        }
        if(m.getTotalGrade() != null){
            writer.setNextPropertyName("totalGrade");
            encoder0.encode(writer, m.getTotalGrade());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected midterm.model.ReportCardModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        midterm.model.ReportCardModel m = new midterm.model.ReportCardModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("gradeLevel");
        m.setGradeLevel(decoder0.decode(reader, m.getGradeLevel()));
        reader = rootReader.newObjectReader("gradingList");
        {
            java.util.ArrayList<java.lang.Integer> elements = new java.util.ArrayList<java.lang.Integer>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("gradingList");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Integer v = decoder0.decode(reader, (java.lang.Integer)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setGradingList(elements);
            }
        }
        reader = rootReader.newObjectReader("gradingPeriod");
        m.setGradingPeriod(decoder0.decode(reader, m.getGradingPeriod()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("passed");
        m.setPassed(decoder0.decode(reader, m.isPassed()));
        reader = rootReader.newObjectReader("sectionName");
        m.setSectionName(decoder0.decode(reader, m.getSectionName()));
        reader = rootReader.newObjectReader("studentName");
        m.setStudentName(decoder0.decode(reader, m.getStudentName()));
        reader = rootReader.newObjectReader("totalGrade");
        m.setTotalGrade(decoder0.decode(reader, m.getTotalGrade()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}