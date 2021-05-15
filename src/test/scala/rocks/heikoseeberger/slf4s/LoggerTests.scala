/*
 * Copyright 2021 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rocks.heikoseeberger.slf4s

import munit.FunSuite
import org.mockito.Mockito.{ mock, never, verify, when }
import org.slf4j.{ MarkerFactory, Logger => Underlying }

final class LoggerTests extends FunSuite:

  private inline val Message = "message"

  private val t = new Exception("error")

  private val marker = MarkerFactory.getMarker("marker")
  
  // Error =========================================================================================

  test("error with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = Logger(underlying)

    when(underlying.isErrorEnabled).thenReturn(false)
    logger.error(Message)
    verify(underlying, never).error(Message)

    when(underlying.isErrorEnabled).thenReturn(true)
    logger.error(Message)
    verify(underlying).error(Message)
  }

  test("error with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled).thenReturn(false)
    logger.error(Message, t)
    verify(underlying, never).error(Message, t)

    when(underlying.isErrorEnabled).thenReturn(true)
    logger.error(Message, t)
    verify(underlying).error(Message, t)
  }

  test("error with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled(marker)).thenReturn(false)
    logger.error(marker, Message)
    verify(underlying, never).error(marker, Message)

    when(underlying.isErrorEnabled(marker)).thenReturn(true)
    logger.error(marker, Message)
    verify(underlying).error(marker, Message)
  }

  test("error with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled(marker)).thenReturn(false)
    logger.error(marker, Message, t)
    verify(underlying, never).error(marker, Message, t)

    when(underlying.isErrorEnabled(marker)).thenReturn(true)
    logger.error(marker, Message, t)
    verify(underlying).error(marker, Message, t)
  }

  // Warn =========================================================================================

  test("warn with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = Logger(underlying)

    when(underlying.isWarnEnabled).thenReturn(false)
    logger.warn(Message)
    verify(underlying, never).warn(Message)

    when(underlying.isWarnEnabled).thenReturn(true)
    logger.warn(Message)
    verify(underlying).warn(Message)
  }

  test("warn with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled).thenReturn(false)
    logger.warn(Message, t)
    verify(underlying, never).warn(Message, t)

    when(underlying.isWarnEnabled).thenReturn(true)
    logger.warn(Message, t)
    verify(underlying).warn(Message, t)
  }
  test("warn with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled(marker)).thenReturn(false)
    logger.warn(marker, Message)
    verify(underlying, never).warn(marker, Message)

    when(underlying.isWarnEnabled(marker)).thenReturn(true)
    logger.warn(marker, Message)
    verify(underlying).warn(marker, Message)
  }

  test("warn with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled(marker)).thenReturn(false)
    logger.warn(marker, Message, t)
    verify(underlying, never).warn(marker, Message, t)

    when(underlying.isWarnEnabled(marker)).thenReturn(true)
    logger.warn(marker, Message, t)
    verify(underlying).warn(marker, Message, t)
  }

  // Info =========================================================================================

  test("info with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = Logger(underlying)

    when(underlying.isInfoEnabled).thenReturn(false)
    logger.info(Message)
    verify(underlying, never).info(Message)

    when(underlying.isInfoEnabled).thenReturn(true)
    logger.info(Message)
    verify(underlying).info(Message)
  }

  test("info with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled).thenReturn(false)
    logger.info(Message, t)
    verify(underlying, never).info(Message, t)

    when(underlying.isInfoEnabled).thenReturn(true)
    logger.info(Message, t)
    verify(underlying).info(Message, t)
  }

  test("info with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled(marker)).thenReturn(false)
    logger.info(marker, Message)
    verify(underlying, never).info(marker, Message)

    when(underlying.isInfoEnabled(marker)).thenReturn(true)
    logger.info(marker, Message)
    verify(underlying).info(marker, Message)
  }

  test("info with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled(marker)).thenReturn(false)
    logger.info(marker, Message, t)
    verify(underlying, never).info(marker, Message, t)

    when(underlying.isInfoEnabled(marker)).thenReturn(true)
    logger.info(marker, Message, t)
    verify(underlying).info(marker, Message, t)
  }

  // Debug =========================================================================================

  test("debug with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = Logger(underlying)

    when(underlying.isDebugEnabled).thenReturn(false)
    logger.debug(Message)
    verify(underlying, never).debug(Message)

    when(underlying.isDebugEnabled).thenReturn(true)
    logger.debug(Message)
    verify(underlying).debug(Message)
  }

  test("debug with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled).thenReturn(false)
    logger.debug(Message, t)
    verify(underlying, never).debug(Message, t)

    when(underlying.isDebugEnabled).thenReturn(true)
    logger.debug(Message, t)
    verify(underlying).debug(Message, t)
  }

  test("debug with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled(marker)).thenReturn(false)
    logger.debug(marker, Message)
    verify(underlying, never).debug(marker, Message)

    when(underlying.isDebugEnabled(marker)).thenReturn(true)
    logger.debug(marker, Message)
    verify(underlying).debug(marker, Message)
  }

  test("debug with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled(marker)).thenReturn(false)
    logger.debug(marker, Message, t)
    verify(underlying, never).debug(marker, Message, t)

    when(underlying.isDebugEnabled(marker)).thenReturn(true)
    logger.debug(marker, Message, t)
    verify(underlying).debug(marker, Message, t)
  }

  // Trace =========================================================================================

  test("trace with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = Logger(underlying)

    when(underlying.isTraceEnabled).thenReturn(false)
    logger.trace(Message)
    verify(underlying, never).trace(Message)

    when(underlying.isTraceEnabled).thenReturn(true)
    logger.trace(Message)
    verify(underlying).trace(Message)
  }

  test("trace with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isTraceEnabled).thenReturn(false)
    logger.trace(Message, t)
    verify(underlying, never).trace(Message, t)

    when(underlying.isTraceEnabled).thenReturn(true)
    logger.trace(Message, t)
    verify(underlying).trace(Message, t)
  }

  test("trace with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isTraceEnabled(marker)).thenReturn(false)
    logger.trace(marker, Message)
    verify(underlying, never).trace(marker, Message)

    when(underlying.isTraceEnabled(marker)).thenReturn(true)
    logger.trace(marker, Message)
    verify(underlying).trace(marker, Message)
  }

  test("trace with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isTraceEnabled(marker)).thenReturn(false)
    logger.trace(marker, Message, t)
    verify(underlying, never).trace(marker, Message, t)

    when(underlying.isTraceEnabled(marker)).thenReturn(true)
    logger.trace(marker, Message, t)
    verify(underlying).trace(marker, Message, t)
  }
