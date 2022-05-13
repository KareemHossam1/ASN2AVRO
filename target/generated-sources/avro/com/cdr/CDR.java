/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cdr;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
/** Generated CDRs schema from simulation tool */
@org.apache.avro.specific.AvroGenerated
public class CDR extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8741640133916083998L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CDR\",\"namespace\":\"com.cdr\",\"doc\":\"Generated CDRs schema from simulation tool\",\"fields\":[{\"name\":\"numberA\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Calling number\"},{\"name\":\"numberB\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Called number\"},{\"name\":\"timestamp\",\"type\":\"long\",\"doc\":\"Call timestamp\",\"logicalType\":\"timestamp-millis\"},{\"name\":\"duration\",\"type\":\"int\",\"doc\":\"Call duration\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CDR> ENCODER =
      new BinaryMessageEncoder<CDR>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CDR> DECODER =
      new BinaryMessageDecoder<CDR>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<CDR> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<CDR> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CDR>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this CDR to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a CDR from a ByteBuffer. */
  public static CDR fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Calling number */
   private java.lang.String numberA;
  /** Called number */
   private java.lang.String numberB;
  /** Call timestamp */
   private long timestamp;
  /** Call duration */
   private int duration;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CDR() {}

  /**
   * All-args constructor.
   * @param numberA Calling number
   * @param numberB Called number
   * @param timestamp Call timestamp
   * @param duration Call duration
   */
  public CDR(java.lang.String numberA, java.lang.String numberB, java.lang.Long timestamp, java.lang.Integer duration) {
    this.numberA = numberA;
    this.numberB = numberB;
    this.timestamp = timestamp;
    this.duration = duration;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return numberA;
    case 1: return numberB;
    case 2: return timestamp;
    case 3: return duration;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: numberA = (java.lang.String)value$; break;
    case 1: numberB = (java.lang.String)value$; break;
    case 2: timestamp = (java.lang.Long)value$; break;
    case 3: duration = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'numberA' field.
   * @return Calling number
   */
  public java.lang.String getNumberA() {
    return numberA;
  }


  /**
   * Gets the value of the 'numberB' field.
   * @return Called number
   */
  public java.lang.String getNumberB() {
    return numberB;
  }


  /**
   * Gets the value of the 'timestamp' field.
   * @return Call timestamp
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }


  /**
   * Gets the value of the 'duration' field.
   * @return Call duration
   */
  public java.lang.Integer getDuration() {
    return duration;
  }


  /**
   * Creates a new CDR RecordBuilder.
   * @return A new CDR RecordBuilder
   */
  public static com.cdr.CDR.Builder newBuilder() {
    return new com.cdr.CDR.Builder();
  }

  /**
   * Creates a new CDR RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CDR RecordBuilder
   */
  public static com.cdr.CDR.Builder newBuilder(com.cdr.CDR.Builder other) {
    return new com.cdr.CDR.Builder(other);
  }

  /**
   * Creates a new CDR RecordBuilder by copying an existing CDR instance.
   * @param other The existing instance to copy.
   * @return A new CDR RecordBuilder
   */
  public static com.cdr.CDR.Builder newBuilder(com.cdr.CDR other) {
    return new com.cdr.CDR.Builder(other);
  }

  /**
   * RecordBuilder for CDR instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CDR>
    implements org.apache.avro.data.RecordBuilder<CDR> {

    /** Calling number */
    private java.lang.String numberA;
    /** Called number */
    private java.lang.String numberB;
    /** Call timestamp */
    private long timestamp;
    /** Call duration */
    private int duration;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.cdr.CDR.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.numberA)) {
        this.numberA = data().deepCopy(fields()[0].schema(), other.numberA);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.numberB)) {
        this.numberB = data().deepCopy(fields()[1].schema(), other.numberB);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[2].schema(), other.timestamp);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.duration)) {
        this.duration = data().deepCopy(fields()[3].schema(), other.duration);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing CDR instance
     * @param other The existing instance to copy.
     */
    private Builder(com.cdr.CDR other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.numberA)) {
        this.numberA = data().deepCopy(fields()[0].schema(), other.numberA);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.numberB)) {
        this.numberB = data().deepCopy(fields()[1].schema(), other.numberB);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[2].schema(), other.timestamp);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.duration)) {
        this.duration = data().deepCopy(fields()[3].schema(), other.duration);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'numberA' field.
      * Calling number
      * @return The value.
      */
    public java.lang.String getNumberA() {
      return numberA;
    }

    /**
      * Sets the value of the 'numberA' field.
      * Calling number
      * @param value The value of 'numberA'.
      * @return This builder.
      */
    public com.cdr.CDR.Builder setNumberA(java.lang.String value) {
      validate(fields()[0], value);
      this.numberA = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'numberA' field has been set.
      * Calling number
      * @return True if the 'numberA' field has been set, false otherwise.
      */
    public boolean hasNumberA() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'numberA' field.
      * Calling number
      * @return This builder.
      */
    public com.cdr.CDR.Builder clearNumberA() {
      numberA = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'numberB' field.
      * Called number
      * @return The value.
      */
    public java.lang.String getNumberB() {
      return numberB;
    }

    /**
      * Sets the value of the 'numberB' field.
      * Called number
      * @param value The value of 'numberB'.
      * @return This builder.
      */
    public com.cdr.CDR.Builder setNumberB(java.lang.String value) {
      validate(fields()[1], value);
      this.numberB = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'numberB' field has been set.
      * Called number
      * @return True if the 'numberB' field has been set, false otherwise.
      */
    public boolean hasNumberB() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'numberB' field.
      * Called number
      * @return This builder.
      */
    public com.cdr.CDR.Builder clearNumberB() {
      numberB = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * Call timestamp
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * Call timestamp
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public com.cdr.CDR.Builder setTimestamp(long value) {
      validate(fields()[2], value);
      this.timestamp = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * Call timestamp
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * Call timestamp
      * @return This builder.
      */
    public com.cdr.CDR.Builder clearTimestamp() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'duration' field.
      * Call duration
      * @return The value.
      */
    public java.lang.Integer getDuration() {
      return duration;
    }

    /**
      * Sets the value of the 'duration' field.
      * Call duration
      * @param value The value of 'duration'.
      * @return This builder.
      */
    public com.cdr.CDR.Builder setDuration(int value) {
      validate(fields()[3], value);
      this.duration = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'duration' field has been set.
      * Call duration
      * @return True if the 'duration' field has been set, false otherwise.
      */
    public boolean hasDuration() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'duration' field.
      * Call duration
      * @return This builder.
      */
    public com.cdr.CDR.Builder clearDuration() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CDR build() {
      try {
        CDR record = new CDR();
        record.numberA = fieldSetFlags()[0] ? this.numberA : (java.lang.String) defaultValue(fields()[0]);
        record.numberB = fieldSetFlags()[1] ? this.numberB : (java.lang.String) defaultValue(fields()[1]);
        record.timestamp = fieldSetFlags()[2] ? this.timestamp : (java.lang.Long) defaultValue(fields()[2]);
        record.duration = fieldSetFlags()[3] ? this.duration : (java.lang.Integer) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CDR>
    WRITER$ = (org.apache.avro.io.DatumWriter<CDR>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CDR>
    READER$ = (org.apache.avro.io.DatumReader<CDR>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
