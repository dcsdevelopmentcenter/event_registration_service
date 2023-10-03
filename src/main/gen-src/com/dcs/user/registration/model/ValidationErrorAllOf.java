/*
 * User Registation API
 * User Registation API
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: test@test.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.dcs.user.registration.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * ValidationErrorAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-20T23:06:51.015514+01:00[Europe/London]")
public class ValidationErrorAllOf {
  public static final String SERIALIZED_NAME_FIELD_NAME = "fieldName";
  @SerializedName(SERIALIZED_NAME_FIELD_NAME)
  private String fieldName;

  public static final String SERIALIZED_NAME_LOCALISED_MESSAGE = "localisedMessage";
  @SerializedName(SERIALIZED_NAME_LOCALISED_MESSAGE)
  private Map<String, String> localisedMessage = new HashMap<>();

  public ValidationErrorAllOf() {
  }

  public ValidationErrorAllOf fieldName(String fieldName) {
    
    this.fieldName = fieldName;
    return this;
  }

   /**
   * Get fieldName
   * @return fieldName
  **/
  @javax.annotation.Nullable
  public String getFieldName() {
    return fieldName;
  }


  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }


  public ValidationErrorAllOf localisedMessage(Map<String, String> localisedMessage) {
    
    this.localisedMessage = localisedMessage;
    return this;
  }

  public ValidationErrorAllOf putLocalisedMessageItem(String key, String localisedMessageItem) {
    if (this.localisedMessage == null) {
      this.localisedMessage = new HashMap<>();
    }
    this.localisedMessage.put(key, localisedMessageItem);
    return this;
  }

   /**
   * Dictionary object where the key is expected to be language isocode (en/de/fr) and the value is expected to be the localised error message.
   * @return localisedMessage
  **/
  @javax.annotation.Nullable
  public Map<String, String> getLocalisedMessage() {
    return localisedMessage;
  }


  public void setLocalisedMessage(Map<String, String> localisedMessage) {
    this.localisedMessage = localisedMessage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationErrorAllOf validationErrorAllOf = (ValidationErrorAllOf) o;
    return Objects.equals(this.fieldName, validationErrorAllOf.fieldName) &&
        Objects.equals(this.localisedMessage, validationErrorAllOf.localisedMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, localisedMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationErrorAllOf {\n");
    sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
    sb.append("    localisedMessage: ").append(toIndentedString(localisedMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("fieldName");
    openapiFields.add("localisedMessage");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ValidationErrorAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ValidationErrorAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ValidationErrorAllOf is not found in the empty JSON string", ValidationErrorAllOf.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ValidationErrorAllOf.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ValidationErrorAllOf` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("fieldName") != null && !jsonObj.get("fieldName").isJsonNull()) && !jsonObj.get("fieldName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fieldName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fieldName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ValidationErrorAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ValidationErrorAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ValidationErrorAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ValidationErrorAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<ValidationErrorAllOf>() {
           @Override
           public void write(JsonWriter out, ValidationErrorAllOf value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ValidationErrorAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }


}
