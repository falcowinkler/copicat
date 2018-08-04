// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: feature.proto

package copicat.proto;

/**
 * <pre>
 * Containers for non-sequential data.
 * </pre>
 *
 * Protobuf type {@code copicat.Feature}
 */
public  final class Feature extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:copicat.Feature)
    FeatureOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Feature.newBuilder() to construct.
  private Feature(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Feature() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Feature(
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
            copicat.proto.BytesList.Builder subBuilder = null;
            if (kindCase_ == 1) {
              subBuilder = ((copicat.proto.BytesList) kind_).toBuilder();
            }
            kind_ =
                input.readMessage(copicat.proto.BytesList.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((copicat.proto.BytesList) kind_);
              kind_ = subBuilder.buildPartial();
            }
            kindCase_ = 1;
            break;
          }
          case 18: {
            copicat.proto.FloatList.Builder subBuilder = null;
            if (kindCase_ == 2) {
              subBuilder = ((copicat.proto.FloatList) kind_).toBuilder();
            }
            kind_ =
                input.readMessage(copicat.proto.FloatList.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((copicat.proto.FloatList) kind_);
              kind_ = subBuilder.buildPartial();
            }
            kindCase_ = 2;
            break;
          }
          case 26: {
            copicat.proto.Int64List.Builder subBuilder = null;
            if (kindCase_ == 3) {
              subBuilder = ((copicat.proto.Int64List) kind_).toBuilder();
            }
            kind_ =
                input.readMessage(copicat.proto.Int64List.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((copicat.proto.Int64List) kind_);
              kind_ = subBuilder.buildPartial();
            }
            kindCase_ = 3;
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
    return copicat.proto.FeatureProtos.internal_static_copicat_Feature_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return copicat.proto.FeatureProtos.internal_static_copicat_Feature_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            copicat.proto.Feature.class, copicat.proto.Feature.Builder.class);
  }

  private int kindCase_ = 0;
  private java.lang.Object kind_;
  public enum KindCase
      implements com.google.protobuf.Internal.EnumLite {
    BYTES_LIST(1),
    FLOAT_LIST(2),
    INT64_LIST(3),
    KIND_NOT_SET(0);
    private final int value;
    private KindCase(int value) {
      this.value = value;
    }
    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static KindCase valueOf(int value) {
      return forNumber(value);
    }

    public static KindCase forNumber(int value) {
      switch (value) {
        case 1: return BYTES_LIST;
        case 2: return FLOAT_LIST;
        case 3: return INT64_LIST;
        case 0: return KIND_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public KindCase
  getKindCase() {
    return KindCase.forNumber(
        kindCase_);
  }

  public static final int BYTES_LIST_FIELD_NUMBER = 1;
  /**
   * <code>.copicat.BytesList bytes_list = 1;</code>
   */
  public boolean hasBytesList() {
    return kindCase_ == 1;
  }
  /**
   * <code>.copicat.BytesList bytes_list = 1;</code>
   */
  public copicat.proto.BytesList getBytesList() {
    if (kindCase_ == 1) {
       return (copicat.proto.BytesList) kind_;
    }
    return copicat.proto.BytesList.getDefaultInstance();
  }
  /**
   * <code>.copicat.BytesList bytes_list = 1;</code>
   */
  public copicat.proto.BytesListOrBuilder getBytesListOrBuilder() {
    if (kindCase_ == 1) {
       return (copicat.proto.BytesList) kind_;
    }
    return copicat.proto.BytesList.getDefaultInstance();
  }

  public static final int FLOAT_LIST_FIELD_NUMBER = 2;
  /**
   * <code>.copicat.FloatList float_list = 2;</code>
   */
  public boolean hasFloatList() {
    return kindCase_ == 2;
  }
  /**
   * <code>.copicat.FloatList float_list = 2;</code>
   */
  public copicat.proto.FloatList getFloatList() {
    if (kindCase_ == 2) {
       return (copicat.proto.FloatList) kind_;
    }
    return copicat.proto.FloatList.getDefaultInstance();
  }
  /**
   * <code>.copicat.FloatList float_list = 2;</code>
   */
  public copicat.proto.FloatListOrBuilder getFloatListOrBuilder() {
    if (kindCase_ == 2) {
       return (copicat.proto.FloatList) kind_;
    }
    return copicat.proto.FloatList.getDefaultInstance();
  }

  public static final int INT64_LIST_FIELD_NUMBER = 3;
  /**
   * <code>.copicat.Int64List int64_list = 3;</code>
   */
  public boolean hasInt64List() {
    return kindCase_ == 3;
  }
  /**
   * <code>.copicat.Int64List int64_list = 3;</code>
   */
  public copicat.proto.Int64List getInt64List() {
    if (kindCase_ == 3) {
       return (copicat.proto.Int64List) kind_;
    }
    return copicat.proto.Int64List.getDefaultInstance();
  }
  /**
   * <code>.copicat.Int64List int64_list = 3;</code>
   */
  public copicat.proto.Int64ListOrBuilder getInt64ListOrBuilder() {
    if (kindCase_ == 3) {
       return (copicat.proto.Int64List) kind_;
    }
    return copicat.proto.Int64List.getDefaultInstance();
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
    if (kindCase_ == 1) {
      output.writeMessage(1, (copicat.proto.BytesList) kind_);
    }
    if (kindCase_ == 2) {
      output.writeMessage(2, (copicat.proto.FloatList) kind_);
    }
    if (kindCase_ == 3) {
      output.writeMessage(3, (copicat.proto.Int64List) kind_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (kindCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (copicat.proto.BytesList) kind_);
    }
    if (kindCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (copicat.proto.FloatList) kind_);
    }
    if (kindCase_ == 3) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, (copicat.proto.Int64List) kind_);
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
    if (!(obj instanceof copicat.proto.Feature)) {
      return super.equals(obj);
    }
    copicat.proto.Feature other = (copicat.proto.Feature) obj;

    boolean result = true;
    result = result && getKindCase().equals(
        other.getKindCase());
    if (!result) return false;
    switch (kindCase_) {
      case 1:
        result = result && getBytesList()
            .equals(other.getBytesList());
        break;
      case 2:
        result = result && getFloatList()
            .equals(other.getFloatList());
        break;
      case 3:
        result = result && getInt64List()
            .equals(other.getInt64List());
        break;
      case 0:
      default:
    }
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
    switch (kindCase_) {
      case 1:
        hash = (37 * hash) + BYTES_LIST_FIELD_NUMBER;
        hash = (53 * hash) + getBytesList().hashCode();
        break;
      case 2:
        hash = (37 * hash) + FLOAT_LIST_FIELD_NUMBER;
        hash = (53 * hash) + getFloatList().hashCode();
        break;
      case 3:
        hash = (37 * hash) + INT64_LIST_FIELD_NUMBER;
        hash = (53 * hash) + getInt64List().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static copicat.proto.Feature parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static copicat.proto.Feature parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static copicat.proto.Feature parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static copicat.proto.Feature parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static copicat.proto.Feature parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static copicat.proto.Feature parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static copicat.proto.Feature parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static copicat.proto.Feature parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static copicat.proto.Feature parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static copicat.proto.Feature parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static copicat.proto.Feature parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static copicat.proto.Feature parseFrom(
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
  public static Builder newBuilder(copicat.proto.Feature prototype) {
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
   * <pre>
   * Containers for non-sequential data.
   * </pre>
   *
   * Protobuf type {@code copicat.Feature}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:copicat.Feature)
      copicat.proto.FeatureOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return copicat.proto.FeatureProtos.internal_static_copicat_Feature_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return copicat.proto.FeatureProtos.internal_static_copicat_Feature_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              copicat.proto.Feature.class, copicat.proto.Feature.Builder.class);
    }

    // Construct using copicat.proto.Feature.newBuilder()
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
      kindCase_ = 0;
      kind_ = null;
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return copicat.proto.FeatureProtos.internal_static_copicat_Feature_descriptor;
    }

    public copicat.proto.Feature getDefaultInstanceForType() {
      return copicat.proto.Feature.getDefaultInstance();
    }

    public copicat.proto.Feature build() {
      copicat.proto.Feature result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public copicat.proto.Feature buildPartial() {
      copicat.proto.Feature result = new copicat.proto.Feature(this);
      if (kindCase_ == 1) {
        if (bytesListBuilder_ == null) {
          result.kind_ = kind_;
        } else {
          result.kind_ = bytesListBuilder_.build();
        }
      }
      if (kindCase_ == 2) {
        if (floatListBuilder_ == null) {
          result.kind_ = kind_;
        } else {
          result.kind_ = floatListBuilder_.build();
        }
      }
      if (kindCase_ == 3) {
        if (int64ListBuilder_ == null) {
          result.kind_ = kind_;
        } else {
          result.kind_ = int64ListBuilder_.build();
        }
      }
      result.kindCase_ = kindCase_;
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
      if (other instanceof copicat.proto.Feature) {
        return mergeFrom((copicat.proto.Feature)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(copicat.proto.Feature other) {
      if (other == copicat.proto.Feature.getDefaultInstance()) return this;
      switch (other.getKindCase()) {
        case BYTES_LIST: {
          mergeBytesList(other.getBytesList());
          break;
        }
        case FLOAT_LIST: {
          mergeFloatList(other.getFloatList());
          break;
        }
        case INT64_LIST: {
          mergeInt64List(other.getInt64List());
          break;
        }
        case KIND_NOT_SET: {
          break;
        }
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
      copicat.proto.Feature parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (copicat.proto.Feature) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int kindCase_ = 0;
    private java.lang.Object kind_;
    public KindCase
        getKindCase() {
      return KindCase.forNumber(
          kindCase_);
    }

    public Builder clearKind() {
      kindCase_ = 0;
      kind_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        copicat.proto.BytesList, copicat.proto.BytesList.Builder, copicat.proto.BytesListOrBuilder> bytesListBuilder_;
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public boolean hasBytesList() {
      return kindCase_ == 1;
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public copicat.proto.BytesList getBytesList() {
      if (bytesListBuilder_ == null) {
        if (kindCase_ == 1) {
          return (copicat.proto.BytesList) kind_;
        }
        return copicat.proto.BytesList.getDefaultInstance();
      } else {
        if (kindCase_ == 1) {
          return bytesListBuilder_.getMessage();
        }
        return copicat.proto.BytesList.getDefaultInstance();
      }
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public Builder setBytesList(copicat.proto.BytesList value) {
      if (bytesListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kind_ = value;
        onChanged();
      } else {
        bytesListBuilder_.setMessage(value);
      }
      kindCase_ = 1;
      return this;
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public Builder setBytesList(
        copicat.proto.BytesList.Builder builderForValue) {
      if (bytesListBuilder_ == null) {
        kind_ = builderForValue.build();
        onChanged();
      } else {
        bytesListBuilder_.setMessage(builderForValue.build());
      }
      kindCase_ = 1;
      return this;
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public Builder mergeBytesList(copicat.proto.BytesList value) {
      if (bytesListBuilder_ == null) {
        if (kindCase_ == 1 &&
            kind_ != copicat.proto.BytesList.getDefaultInstance()) {
          kind_ = copicat.proto.BytesList.newBuilder((copicat.proto.BytesList) kind_)
              .mergeFrom(value).buildPartial();
        } else {
          kind_ = value;
        }
        onChanged();
      } else {
        if (kindCase_ == 1) {
          bytesListBuilder_.mergeFrom(value);
        }
        bytesListBuilder_.setMessage(value);
      }
      kindCase_ = 1;
      return this;
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public Builder clearBytesList() {
      if (bytesListBuilder_ == null) {
        if (kindCase_ == 1) {
          kindCase_ = 0;
          kind_ = null;
          onChanged();
        }
      } else {
        if (kindCase_ == 1) {
          kindCase_ = 0;
          kind_ = null;
        }
        bytesListBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public copicat.proto.BytesList.Builder getBytesListBuilder() {
      return getBytesListFieldBuilder().getBuilder();
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    public copicat.proto.BytesListOrBuilder getBytesListOrBuilder() {
      if ((kindCase_ == 1) && (bytesListBuilder_ != null)) {
        return bytesListBuilder_.getMessageOrBuilder();
      } else {
        if (kindCase_ == 1) {
          return (copicat.proto.BytesList) kind_;
        }
        return copicat.proto.BytesList.getDefaultInstance();
      }
    }
    /**
     * <code>.copicat.BytesList bytes_list = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        copicat.proto.BytesList, copicat.proto.BytesList.Builder, copicat.proto.BytesListOrBuilder> 
        getBytesListFieldBuilder() {
      if (bytesListBuilder_ == null) {
        if (!(kindCase_ == 1)) {
          kind_ = copicat.proto.BytesList.getDefaultInstance();
        }
        bytesListBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            copicat.proto.BytesList, copicat.proto.BytesList.Builder, copicat.proto.BytesListOrBuilder>(
                (copicat.proto.BytesList) kind_,
                getParentForChildren(),
                isClean());
        kind_ = null;
      }
      kindCase_ = 1;
      onChanged();;
      return bytesListBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        copicat.proto.FloatList, copicat.proto.FloatList.Builder, copicat.proto.FloatListOrBuilder> floatListBuilder_;
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public boolean hasFloatList() {
      return kindCase_ == 2;
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public copicat.proto.FloatList getFloatList() {
      if (floatListBuilder_ == null) {
        if (kindCase_ == 2) {
          return (copicat.proto.FloatList) kind_;
        }
        return copicat.proto.FloatList.getDefaultInstance();
      } else {
        if (kindCase_ == 2) {
          return floatListBuilder_.getMessage();
        }
        return copicat.proto.FloatList.getDefaultInstance();
      }
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public Builder setFloatList(copicat.proto.FloatList value) {
      if (floatListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kind_ = value;
        onChanged();
      } else {
        floatListBuilder_.setMessage(value);
      }
      kindCase_ = 2;
      return this;
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public Builder setFloatList(
        copicat.proto.FloatList.Builder builderForValue) {
      if (floatListBuilder_ == null) {
        kind_ = builderForValue.build();
        onChanged();
      } else {
        floatListBuilder_.setMessage(builderForValue.build());
      }
      kindCase_ = 2;
      return this;
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public Builder mergeFloatList(copicat.proto.FloatList value) {
      if (floatListBuilder_ == null) {
        if (kindCase_ == 2 &&
            kind_ != copicat.proto.FloatList.getDefaultInstance()) {
          kind_ = copicat.proto.FloatList.newBuilder((copicat.proto.FloatList) kind_)
              .mergeFrom(value).buildPartial();
        } else {
          kind_ = value;
        }
        onChanged();
      } else {
        if (kindCase_ == 2) {
          floatListBuilder_.mergeFrom(value);
        }
        floatListBuilder_.setMessage(value);
      }
      kindCase_ = 2;
      return this;
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public Builder clearFloatList() {
      if (floatListBuilder_ == null) {
        if (kindCase_ == 2) {
          kindCase_ = 0;
          kind_ = null;
          onChanged();
        }
      } else {
        if (kindCase_ == 2) {
          kindCase_ = 0;
          kind_ = null;
        }
        floatListBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public copicat.proto.FloatList.Builder getFloatListBuilder() {
      return getFloatListFieldBuilder().getBuilder();
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    public copicat.proto.FloatListOrBuilder getFloatListOrBuilder() {
      if ((kindCase_ == 2) && (floatListBuilder_ != null)) {
        return floatListBuilder_.getMessageOrBuilder();
      } else {
        if (kindCase_ == 2) {
          return (copicat.proto.FloatList) kind_;
        }
        return copicat.proto.FloatList.getDefaultInstance();
      }
    }
    /**
     * <code>.copicat.FloatList float_list = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        copicat.proto.FloatList, copicat.proto.FloatList.Builder, copicat.proto.FloatListOrBuilder> 
        getFloatListFieldBuilder() {
      if (floatListBuilder_ == null) {
        if (!(kindCase_ == 2)) {
          kind_ = copicat.proto.FloatList.getDefaultInstance();
        }
        floatListBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            copicat.proto.FloatList, copicat.proto.FloatList.Builder, copicat.proto.FloatListOrBuilder>(
                (copicat.proto.FloatList) kind_,
                getParentForChildren(),
                isClean());
        kind_ = null;
      }
      kindCase_ = 2;
      onChanged();;
      return floatListBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        copicat.proto.Int64List, copicat.proto.Int64List.Builder, copicat.proto.Int64ListOrBuilder> int64ListBuilder_;
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public boolean hasInt64List() {
      return kindCase_ == 3;
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public copicat.proto.Int64List getInt64List() {
      if (int64ListBuilder_ == null) {
        if (kindCase_ == 3) {
          return (copicat.proto.Int64List) kind_;
        }
        return copicat.proto.Int64List.getDefaultInstance();
      } else {
        if (kindCase_ == 3) {
          return int64ListBuilder_.getMessage();
        }
        return copicat.proto.Int64List.getDefaultInstance();
      }
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public Builder setInt64List(copicat.proto.Int64List value) {
      if (int64ListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        kind_ = value;
        onChanged();
      } else {
        int64ListBuilder_.setMessage(value);
      }
      kindCase_ = 3;
      return this;
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public Builder setInt64List(
        copicat.proto.Int64List.Builder builderForValue) {
      if (int64ListBuilder_ == null) {
        kind_ = builderForValue.build();
        onChanged();
      } else {
        int64ListBuilder_.setMessage(builderForValue.build());
      }
      kindCase_ = 3;
      return this;
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public Builder mergeInt64List(copicat.proto.Int64List value) {
      if (int64ListBuilder_ == null) {
        if (kindCase_ == 3 &&
            kind_ != copicat.proto.Int64List.getDefaultInstance()) {
          kind_ = copicat.proto.Int64List.newBuilder((copicat.proto.Int64List) kind_)
              .mergeFrom(value).buildPartial();
        } else {
          kind_ = value;
        }
        onChanged();
      } else {
        if (kindCase_ == 3) {
          int64ListBuilder_.mergeFrom(value);
        }
        int64ListBuilder_.setMessage(value);
      }
      kindCase_ = 3;
      return this;
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public Builder clearInt64List() {
      if (int64ListBuilder_ == null) {
        if (kindCase_ == 3) {
          kindCase_ = 0;
          kind_ = null;
          onChanged();
        }
      } else {
        if (kindCase_ == 3) {
          kindCase_ = 0;
          kind_ = null;
        }
        int64ListBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public copicat.proto.Int64List.Builder getInt64ListBuilder() {
      return getInt64ListFieldBuilder().getBuilder();
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    public copicat.proto.Int64ListOrBuilder getInt64ListOrBuilder() {
      if ((kindCase_ == 3) && (int64ListBuilder_ != null)) {
        return int64ListBuilder_.getMessageOrBuilder();
      } else {
        if (kindCase_ == 3) {
          return (copicat.proto.Int64List) kind_;
        }
        return copicat.proto.Int64List.getDefaultInstance();
      }
    }
    /**
     * <code>.copicat.Int64List int64_list = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        copicat.proto.Int64List, copicat.proto.Int64List.Builder, copicat.proto.Int64ListOrBuilder> 
        getInt64ListFieldBuilder() {
      if (int64ListBuilder_ == null) {
        if (!(kindCase_ == 3)) {
          kind_ = copicat.proto.Int64List.getDefaultInstance();
        }
        int64ListBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            copicat.proto.Int64List, copicat.proto.Int64List.Builder, copicat.proto.Int64ListOrBuilder>(
                (copicat.proto.Int64List) kind_,
                getParentForChildren(),
                isClean());
        kind_ = null;
      }
      kindCase_ = 3;
      onChanged();;
      return int64ListBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:copicat.Feature)
  }

  // @@protoc_insertion_point(class_scope:copicat.Feature)
  private static final copicat.proto.Feature DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new copicat.proto.Feature();
  }

  public static copicat.proto.Feature getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Feature>
      PARSER = new com.google.protobuf.AbstractParser<Feature>() {
    public Feature parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Feature(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Feature> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Feature> getParserForType() {
    return PARSER;
  }

  public copicat.proto.Feature getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

