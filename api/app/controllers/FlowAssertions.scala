package controllers

import io.flow.util.Constants

trait FlowAssertions {

  def assertFlow(organizationId: String): Unit = {
    assert(
      organizationId == Constants.FlowOrganizationId,
      s"Invalid organizationId[$organizationId]"
    )
  }

}

