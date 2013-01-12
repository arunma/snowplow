/*
 * Copyright (c) 2012 SnowPlow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.snowplow.hadoop

// Scalaz
import scalaz._
import Scalaz._

// Apache URLEncodedUtils
import org.apache.http.NameValuePair

// This project
import etl.inputs.CanonicalInput

/**
 * Scala package object to hold types,
 * helper methods etc.
 *
 * See:
 * http://www.artima.com/scalazine/articles/package_objects.html
 */
package object etl {

	/**
	 * Type alias for a non-empty
	 * set of name-value pairs
	 */
	type NameValueNEL = NonEmptyList[NameValuePair]

  /**
   * Type alias for either a `ValidationNEL`
   * or an Option-boxed `CanonicalInput`.
   *
   * @tparam E the type of `Failure`
   */
  type MaybeCanonicalInput[E] = ValidationNEL[E, Option[CanonicalInput]]

  /**
   * Type alias for a `Validation`
   * containing either error `String`s
   * or a `NameValueNEL`.
   *
   * See package object for `NameValueNEL`
   * definition.
   *
   * @tparam E the type of `Failure`
   */
  type MaybeNameValueNEL[E] = Validation[E, NameValueNEL]
}