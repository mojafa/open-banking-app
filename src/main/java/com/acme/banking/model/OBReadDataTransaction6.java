package com.acme.banking.model;

import java.util.Objects;
import com.acme.banking.model.OBTransaction6;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * OBReadDataTransaction6
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-10T19:39:13.527250+02:00[Africa/Johannesburg]")
public class OBReadDataTransaction6   {
  @JsonProperty("Transaction")
  
  private List<OBTransaction6> transaction = null;

  public OBReadDataTransaction6 transaction(List<OBTransaction6> transaction) {
    this.transaction = transaction;
    return this;
  }

  public OBReadDataTransaction6 addTransactionItem(OBTransaction6 transactionItem) {
    if (this.transaction == null) {
      this.transaction = new ArrayList<OBTransaction6>();
    }
    this.transaction.add(transactionItem);
    return this;
  }

  /**
   * Get transaction
   * @return transaction
  */
  @ApiModelProperty(value = "")
  public List<OBTransaction6> getTransaction() {
    return transaction;
  }

  public void setTransaction(List<OBTransaction6> transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadDataTransaction6 obReadDataTransaction6 = (OBReadDataTransaction6) o;
    return Objects.equals(this.transaction, obReadDataTransaction6.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadDataTransaction6 {\n");
    
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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
}

