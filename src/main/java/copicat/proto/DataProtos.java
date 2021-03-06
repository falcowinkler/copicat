// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tile_data.proto

package copicat.proto;

public final class DataProtos {
  private DataProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TileDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:copicat.proto.TileData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bytes raw_data = 1;</code>
     */
    com.google.protobuf.ByteString getRawData();
  }
  /**
   * Protobuf type {@code copicat.proto.TileData}
   */
  public  static final class TileData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:copicat.proto.TileData)
      TileDataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TileData.newBuilder() to construct.
    private TileData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TileData() {
      rawData_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TileData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {

              rawData_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return copicat.proto.DataProtos.internal_static_copicat_proto_TileData_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return copicat.proto.DataProtos.internal_static_copicat_proto_TileData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              copicat.proto.DataProtos.TileData.class, copicat.proto.DataProtos.TileData.Builder.class);
    }

    public static final int RAW_DATA_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString rawData_;
    /**
     * <code>bytes raw_data = 1;</code>
     */
    public com.google.protobuf.ByteString getRawData() {
      return rawData_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!rawData_.isEmpty()) {
        output.writeBytes(1, rawData_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!rawData_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, rawData_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof copicat.proto.DataProtos.TileData)) {
        return super.equals(obj);
      }
      copicat.proto.DataProtos.TileData other = (copicat.proto.DataProtos.TileData) obj;

      boolean result = true;
      result = result && getRawData()
          .equals(other.getRawData());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + RAW_DATA_FIELD_NUMBER;
      hash = (53 * hash) + getRawData().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static copicat.proto.DataProtos.TileData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static copicat.proto.DataProtos.TileData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static copicat.proto.DataProtos.TileData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static copicat.proto.DataProtos.TileData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(copicat.proto.DataProtos.TileData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code copicat.proto.TileData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:copicat.proto.TileData)
        copicat.proto.DataProtos.TileDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return copicat.proto.DataProtos.internal_static_copicat_proto_TileData_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return copicat.proto.DataProtos.internal_static_copicat_proto_TileData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                copicat.proto.DataProtos.TileData.class, copicat.proto.DataProtos.TileData.Builder.class);
      }

      // Construct using copicat.proto.DataProtos.TileData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        rawData_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return copicat.proto.DataProtos.internal_static_copicat_proto_TileData_descriptor;
      }

      public copicat.proto.DataProtos.TileData getDefaultInstanceForType() {
        return copicat.proto.DataProtos.TileData.getDefaultInstance();
      }

      public copicat.proto.DataProtos.TileData build() {
        copicat.proto.DataProtos.TileData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public copicat.proto.DataProtos.TileData buildPartial() {
        copicat.proto.DataProtos.TileData result = new copicat.proto.DataProtos.TileData(this);
        result.rawData_ = rawData_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof copicat.proto.DataProtos.TileData) {
          return mergeFrom((copicat.proto.DataProtos.TileData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(copicat.proto.DataProtos.TileData other) {
        if (other == copicat.proto.DataProtos.TileData.getDefaultInstance()) return this;
        if (other.getRawData() != com.google.protobuf.ByteString.EMPTY) {
          setRawData(other.getRawData());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        copicat.proto.DataProtos.TileData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (copicat.proto.DataProtos.TileData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.google.protobuf.ByteString rawData_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes raw_data = 1;</code>
       */
      public com.google.protobuf.ByteString getRawData() {
        return rawData_;
      }
      /**
       * <code>bytes raw_data = 1;</code>
       */
      public Builder setRawData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        rawData_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes raw_data = 1;</code>
       */
      public Builder clearRawData() {
        
        rawData_ = getDefaultInstance().getRawData();
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:copicat.proto.TileData)
    }

    // @@protoc_insertion_point(class_scope:copicat.proto.TileData)
    private static final copicat.proto.DataProtos.TileData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new copicat.proto.DataProtos.TileData();
    }

    public static copicat.proto.DataProtos.TileData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TileData>
        PARSER = new com.google.protobuf.AbstractParser<TileData>() {
      public TileData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TileData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TileData> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TileData> getParserForType() {
      return PARSER;
    }

    public copicat.proto.DataProtos.TileData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_copicat_proto_TileData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_copicat_proto_TileData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017tile_data.proto\022\rcopicat.proto\"\034\n\010Tile" +
      "Data\022\020\n\010raw_data\030\001 \001(\014B\014B\nDataProtosb\006pr" +
      "oto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_copicat_proto_TileData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_copicat_proto_TileData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_copicat_proto_TileData_descriptor,
        new java.lang.String[] { "RawData", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
