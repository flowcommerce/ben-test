package controllers

import io.flow.test.utils.{FlowMockClient, FlowPlaySpec}

trait MockClient extends FlowPlaySpec with FlowMockClient[
  io.flow.ben_test.v0.Client,
  io.flow.ben_test.v0.errors.GenericErrorResponse,
  io.flow.ben_test.v0.errors.UnitResponse
] {
}
