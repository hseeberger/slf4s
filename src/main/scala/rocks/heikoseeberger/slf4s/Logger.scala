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

import org.slf4j.{ Logger => Underlying, LoggerFactory, Marker }

/**
  * Logger wrapping a SLF4J logger, applying the check-enabled-idiom to the log methods.
  * @param u
  *   Wrapped SLF4J logger.
  */
final class Logger(u: Underlying):

  /**
    * [[Logger]] wrapping a SLF4J logger named as given with a potential trailing "$" stripped off.
    * @param name
    *   [[Logger]] name
    */
  def this(name: String) = this(LoggerFactory.getLogger(Logger.stripTrailingDollar(name)))

  /**
    * [[Logger]] wrapping a Log4j logger named according to the given `Class` with a potential
    * trailing "$" stripped off.
    * @param `class`
    *   Class to use for the [[Logger]] name
    */
  def this(`class`: Class[_]) = this(`class`.getName)

  /**
    * Returns the name of this [[Logger]].
    * @return
    *   The name of this [[Logger]].
    */
  def name: String =
    u.getName

  /**
    * Logs at `ERROR` level, if enabled.
    * @param message
    *   Log message; only constructed, if `ERROR` level enabled.
    */
  inline def error(message: => String): Unit =
    if u.isErrorEnabled then u.error(message)

  /**
    * Logs at `ERROR` level, if enabled.
    * @param message
    *   Log message; only constructed, if `ERROR` level enabled.
    * @param t
    *   `Throwable` to be logged
    */
  inline def error(message: => String, t: Throwable): Unit =
    if u.isErrorEnabled then u.error(message, t)

  /**
    * Logs at `ERROR` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `ERROR` level enabled.
    */
  inline def error(marker: Marker, message: => String): Unit =
    if u.isErrorEnabled(marker) then u.error(marker, message)

  /**
    * Logs at `ERROR` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `ERROR` level enabled.
    * @param t
    *   `Throwable` to be logged.
    */
  inline def error(marker: Marker, message: => String, t: Throwable): Unit =
    if u.isErrorEnabled(marker) then u.error(marker, message, t)

  /**
    * Logs at `WARN` level, if enabled.
    * @param message
    *   Log message; only constructed, if `WARN` level enabled.
    */
  inline def warn(message: => String): Unit =
    if u.isWarnEnabled then u.warn(message)

  /**
    * Logs at `WARN` level, if enabled.
    * @param message
    *   Log message; only constructed, if `WARN` level enabled.
    * @param t
    *   `Throwable` to be logged
    */
  inline def warn(message: => String, t: Throwable): Unit =
    if u.isWarnEnabled then u.warn(message, t)

  /**
    * Logs at `WARN` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `WARN` level enabled.
    */
  inline def warn(marker: Marker, message: => String): Unit =
    if u.isWarnEnabled(marker) then u.warn(marker, message)

  /**
    * Logs at `WARN` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `WARN` level enabled.
    * @param t
    *   `Throwable` to be logged.
    */
  inline def warn(marker: Marker, message: => String, t: Throwable): Unit =
    if u.isWarnEnabled(marker) then u.warn(marker, message, t)

  /**
    * Logs at `INFO` level, if enabled.
    * @param message
    *   Log message; only constructed, if `INFO` level enabled.
    */
  inline def info(message: => String): Unit =
    if u.isInfoEnabled then u.info(message)

  /**
    * Logs at `INFO` level, if enabled.
    * @param message
    *   Log message; only constructed, if `INFO` level enabled.
    * @param t
    *   `Throwable` to be logged
    */
  inline def info(message: => String, t: Throwable): Unit =
    if u.isInfoEnabled then u.info(message, t)

  /**
    * Logs at `INFO` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `INFO` level enabled.
    */
  inline def info(marker: Marker, message: => String): Unit =
    if u.isInfoEnabled(marker) then u.info(marker, message)

  /**
    * Logs at `INFO` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `INFO` level enabled.
    * @param t
    *   `Throwable` to be logged.
    */
  inline def info(marker: Marker, message: => String, t: Throwable): Unit =
    if u.isInfoEnabled(marker) then u.info(marker, message, t)

  /**
    * Logs at `DEBUG` level, if enabled.
    * @param message
    *   Log message; only constructed, if `DEBUG` level enabled.
    */
  inline def debug(message: => String): Unit =
    if u.isDebugEnabled then u.debug(message)

  /**
    * Logs at `DEBUG` level, if enabled.
    * @param message
    *   Log message; only constructed, if `DEBUG` level enabled.
    * @param t
    *   `Throwable` to be logged
    */
  inline def debug(message: => String, t: Throwable): Unit =
    if u.isDebugEnabled then u.debug(message, t)

  /**
    * Logs at `DEBUG` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `DEBUG` level enabled.
    */
  inline def debug(marker: Marker, message: => String): Unit =
    if u.isDebugEnabled(marker) then u.debug(marker, message)

  /**
    * Logs at `DEBUG` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `DEBUG` level enabled.
    * @param t
    *   `Throwable` to be logged.
    */
  inline def debug(marker: Marker, message: => String, t: Throwable): Unit =
    if u.isDebugEnabled(marker) then u.debug(marker, message, t)

  /**
    * Logs at `TRACE` level, if enabled.
    * @param message
    *   Log message; only constructed, if `TRACE` level enabled.
    */
  inline def trace(message: => String): Unit =
    if u.isTraceEnabled then u.trace(message)

  /**
    * Logs at `TRACE` level, if enabled.
    * @param message
    *   Log message; only constructed, if `TRACE` level enabled.
    * @param t
    *   `Throwable` to be logged
    */
  inline def trace(message: => String, t: Throwable): Unit =
    if u.isTraceEnabled then u.trace(message, t)

  /**
    * Logs at `TRACE` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `TRACE` level enabled.
    */
  inline def trace(marker: Marker, message: => String): Unit =
    if u.isTraceEnabled(marker) then u.trace(marker, message)

  /**
    * Logs at `TRACE` level, if enabled.
    * @param marker
    *   `Marker` for this log statement.
    * @param message
    *   Log message; only constructed, if `TRACE` level enabled.
    * @param t
    *   `Throwable` to be logged.
    */
  inline def trace(marker: Marker, message: => String, t: Throwable): Unit =
    if u.isTraceEnabled(marker) then u.trace(marker, message, t)

object Logger:

  private def stripTrailingDollar(name: String) =
    if name.endsWith("$") then name.init
    else name
